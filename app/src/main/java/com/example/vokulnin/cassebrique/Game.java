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

    //ijfe
    public ImageView test2;
    Handler handler = new Handler();
    public Myview test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bricks = new ArrayList<Brick>();
        raquette = new Raquette(this);
        balle = new Ball(this);
        test  = new Myview(this , this);
        setContentView(test);
        //test = (Myview) findViewById(R.id.MyView);

        width = test.getWidth();
        height = test.getHeight();

        for(int i=0;i<5 ; i++){
            bricks.add(new Brick(this ,   110*i , 500 , 100, 50));
        }



        //setContentView(test);

        Runnable r = new Runnable() {
            public void run() {
                handler.postDelayed(this, 20);
                width = test.getWidth();
                height = test.getHeight();

                balle.Move();
                test.invalidate();

                if (raquette.Collide(balle)){
                    balle.Bounce();
                }
                for(int i=0;i<bricks.size();i++){
                    if(bricks.get(i).Collide(balle)){
                        balle.Bounce();
                        bricks.remove(i);
                    }
                }

            }
        };
        handler.postDelayed(r, 20);
    }


    public boolean onTouchEvent(MotionEvent e) {

        if(e.getAction() == MotionEvent.ACTION_MOVE){
            raquette.Move(e.getX() , raquette.pos_Y);
        }

        return true;
    }
}
