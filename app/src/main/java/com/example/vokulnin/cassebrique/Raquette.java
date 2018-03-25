package com.example.vokulnin.cassebrique;

import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Raquette {
    public ImageView raquette;
    public float size_X;
    public float size_Y;

    public void  Move(float posX ) {

            raquette.setX(posX);
    }

    public Raquette(ImageView Raquette){
        raquette = Raquette;
    }
}
