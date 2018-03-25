package com.example.vokulnin.cassebrique;

import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Ball {
    public ImageView ball;
    public float size_X;
    public float size_Y;

    public void  Move() {

        ball.setY(ball.getY() +10);
    }

    public Ball(ImageView Ball){
        ball = Ball;
    }
}
