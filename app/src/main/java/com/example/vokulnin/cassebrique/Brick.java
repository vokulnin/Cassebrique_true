package com.example.vokulnin.cassebrique;

import android.graphics.RectF;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Brick {
    public Game main;
    public float size_X ;
    public float size_Y ;
    public float pos_X ;
    public float pos_Y ;



    public Brick(Game Main , int PosX , int PosY , int Size_X , int Size_Y){
        main = Main;
        size_X = Size_X;
        size_Y =Size_Y;
        pos_X = PosX;
        pos_Y = PosY;

    }

    public RectF Draw(){
        RectF raquette = new RectF(pos_X , pos_Y , pos_X + size_X , pos_Y+ size_Y);
        return raquette;
    }

    public boolean Collide(Ball other){
        if(Draw().intersect(other.Draw())){
            return  true;
        }
        else{
            return false;
        }
    }

}
