package com.example.vokulnin.cassebrique;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {
    public Raquette raquette;
    public Ball balle;
    public float width = 1;
    public float height = 1;
    public List<Brick> bricks;
    public BrickGenerator generator;
    public GameState gamestate;
    //ijfe
    public ImageView test2;
    Handler handler = new Handler();
    public Myview test;

    public Boolean first_frame = true;
    public Boolean generated = false;


    public void create(){
        bricks = new ArrayList<Brick>();
        raquette = new Raquette(this);
        balle = new Ball(this);
        //test = (Myview) findViewById(R.id.MyView);
        width = test.getWidth();
        height = test.getHeight();

        gamestate = new GameState(this);
        generator = new BrickGenerator(this,10,5);
        //generator.Generate();
        generated = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test  = new Myview(this , this);
        setContentView(test);







        //setContentView(test);

        Runnable r = new Runnable() {
            public void run() {
                test.invalidate();

                handler.postDelayed(this, 20);
                if(first_frame){
                    first_frame = false;
                }
                else{

                    if(!generated){create();
                    generated = true;
                    }
                    //width = test.getWidth();
                    //height = test.getHeight();
                    if(gamestate.Brick_left <=0){
                        gamestate.GameFinished();
                    }
                    balle.Move();
                    if(balle.pos_Y > raquette.pos_Y + raquette.size_Y){
                        gamestate.Ball_lost();
                    }

                    if (raquette.Collide(balle)){
                        balle.Raquette_Bounce();
                    }
                    for(int i=0;i<bricks.size();i++){
                        if(bricks.get(i).Collide(balle)){
                            balle.Bounce();
                            bricks.remove(i);
                            gamestate.score +=10;
                            gamestate.Brick_left -= 1;
                        }
                    }
                }


            }
        };
        handler.postDelayed(r, 20);
    }


    public boolean onTouchEvent(MotionEvent e) {

        if(e.getAction() == MotionEvent.ACTION_MOVE){
            raquette.Move(e.getX() - raquette.size_X/2 , raquette.pos_Y);
        }

        return true;
    }
}
