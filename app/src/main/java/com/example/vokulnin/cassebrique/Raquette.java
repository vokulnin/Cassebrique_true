package com.example.vokulnin.cassebrique;

import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Raquette {
    public float size_X = 200;
    public float size_Y = 50;
    public float pos_X = 500;
    public float pos_Y = 100;
    public void  Move(float PosX , float PosY ) {

            pos_X = PosX;
        pos_Y = PosY;
    }

    public Raquette(){

    }
}
