package com.example.vokulnin.cassebrique;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Game extends AppCompatActivity {
    public Raquette raquette;
    public Ball balle;
    //ijfe
    public ImageView test2;
    Handler handler = new Handler();
    public Myview test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        raquette = new Raquette();
        balle = new Ball();
          test  = new Myview(this , this);
        setContentView(test);

        Runnable r = new Runnable() {
            public void run() {
                handler.postDelayed(this, 20);
                balle.Move();
                test.invalidate();

            }
        };
        handler.postDelayed(r, 20);
    }


    public boolean onTouchEvent(MotionEvent e) {

        if(e.getAction() == MotionEvent.ACTION_MOVE){
            raquette.pos_X = e.getX();
        }

        return true;
    }
}
