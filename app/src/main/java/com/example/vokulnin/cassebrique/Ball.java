package com.example.vokulnin.cassebrique;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Ball {
    public ImageView ball;
    public float size_X = 200;
    public float size_Y = 50;
    public float pos_X = 500;
    public float pos_Y = 100;
    public float speed_X;
    public float speed_Y = 1;

    public void  Move() {

        pos_X = pos_X + speed_X;
        pos_Y = pos_Y + speed_Y;
    }
    public Ball(){

    }

    public RectF  Draw(){
        RectF balle = new RectF(pos_X , pos_Y , pos_X + size_X , pos_Y+ size_Y);
        return balle;
    }
}
