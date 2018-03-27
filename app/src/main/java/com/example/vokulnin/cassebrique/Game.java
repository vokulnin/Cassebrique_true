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
    public ImageView test;
    public ImageView test2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        test = findViewById(R.id.Raquette);
        test2 = findViewById(R.id.Ball);

        raquette = new Raquette(test);
        balle = new Ball(test2);
        Runnable r = new Runnable() {
            public void run() {
                balle.Move();
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(r, 100);
    }


    public boolean onTouchEvent(MotionEvent e) {

        if(e.getAction() == MotionEvent.ACTION_MOVE){
            raquette.Move(e.getX());
        }

        return true;
    }
}
