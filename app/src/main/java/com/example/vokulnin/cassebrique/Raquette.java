package com.example.vokulnin.cassebrique;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Raquette {
    public Game main;

    public float size_X ;
    public float size_Y ;
    public float pos_X ;
    public float pos_Y ;

    public void  Move(float PosX , float PosY ) {
        size_X = main.width * 0.25f;
        size_Y = main.height * 0.01f;
        pos_X = PosX;
        pos_Y = main.height * 0.75f;
    }
    public boolean Collide(Ball other){
        if(Draw().intersect(other.Draw())){
            return  true;
        }
        else{
            return false;
        }
    }
    public Raquette(Game Main){
    main = Main;
        size_X = main.width * 0.3f;
        size_Y = main.height * 0.1f;
        pos_X = main.width * 0.5f;
        pos_Y = main.height * 0.25f;
    }

    public RectF  Draw(){
        RectF raquette = new RectF(pos_X , pos_Y , pos_X + size_X , pos_Y+ size_Y);
        return raquette;
    }
}
