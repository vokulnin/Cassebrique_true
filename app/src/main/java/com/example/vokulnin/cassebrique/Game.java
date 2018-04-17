package com.example.vokulnin.cassebrique;

import android.content.Intent;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

public class Game extends AppCompatActivity {
    public Raquette raquette;
    public Ball balle;
    public float width = 1;
    public float height = 1;
    public List<Brick> bricks;
    public BrickGenerator generator;
    public GameState gamestate;
    public ImageView test2;
    public TextView score;
    public TextView life;
    public TextView level;
    Handler handler = new Handler();
    public Myview test;

    public Boolean first_frame = true;
    public Boolean generated = false;
    public Boolean running ;

    public void save(){
        Slot toSave = new Slot("test" , bricks , gamestate.level , gamestate.score , gamestate.Ball_left);
        Save.ref.saves.add(toSave);
        Save.ref.saveObject();
    }

    public void onLoad(Slot LoadData){

    }
    public void create(){
        bricks = new ArrayList<Brick>();
        raquette = new Raquette(this);
        balle = new Ball(this);
        //test = (Myview) findViewById(R.id.MyView);
        width = test.getWidth();
        height = test.getHeight();
        running = false;
        gamestate = new GameState(this);
        generator = new BrickGenerator(this,10,5);
        //generator.Generate();
        generated = true;
        balle.pos_X = width * 0.5f;
        balle.pos_Y = height * 0.5f;

    }

    public void chargeScore(Boolean won){
        Intent intent = new Intent(this , Result.class );
        intent.putExtra("score" , gamestate.score);
        intent.putExtra("Won" , won);

        startActivity(intent);
        this.finish();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        save();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test  = new Myview(this , this);
        //setContentView(test);
        setContentView(R.layout.activity_game);
        test = (Myview)findViewById(R.id.view);
        test.main = this;
        score = findViewById(R.id.score);
        life = findViewById(R.id.life);
        level = findViewById(R.id.level);
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
                    score.setText("score " + Integer.toString(gamestate.score));
                    life.setText("Ball left " + Integer.toString(gamestate.Ball_left));
                    level.setText("Level  " + Integer.toString(gamestate.level));

                    //width = test.getWidth();
                    //height = test.getHeight();
                    if(gamestate.Brick_left <=0){
                        gamestate.GameFinished();
                    }
                    if(running){
                    balle.Move();
                        if(balle.pos_Y > raquette.pos_Y + raquette.size_Y){
                            gamestate.Ball_lost();
                        }}


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
            running = true;
        }

        return true;
    }
}
