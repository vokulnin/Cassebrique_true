package com.example.vokulnin.cassebrique;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Ball {
    public Game main;
    public ImageView ball;
    public float size_X ;
    public float size_Y ;
    public float pos_X  = 100;
    public float pos_Y  = 10;
    public float speed_X = 15f;
    public float speed_Y = 4f;
    public float speed;

    public void  Move() {
        size_X = main.width * 0.01f;
        size_Y = main.width * 0.01f;
        pos_X = pos_X + speed_X;
        pos_Y = pos_Y + speed_Y;
        speed = (float)Math.sqrt(Math.pow(speed_X,2) + Math.pow(speed_Y,2));

        if(touch_side()){
            speed_X = -speed_X;
        }
        if(touch_up()){
            speed_Y = -speed_Y;
        }
    }
    public Ball(Game Main){
        main = Main;

        size_X = main.width * 0.25f;
        size_Y = main.width * 0.25f;
        pos_X = main.width * 0.5f;
        pos_Y = main.height * 0.5f;

    }
    public float convert_to_angle(){
        return (float)Math.atan(speed_Y/speed_X);
    }

    public void angle_to_speed(float angle){
        speed_X =  (float)(Math.cos(angle) * speed);
        speed_Y =  (float)(Math.sin(angle) * speed);

    }
    public void Bounce(){
        //angle_to_speed((float) (convert_to_angle()) + (float)Math.toRadians(70));
        angle_to_speed((float) (Math.toRadians(  Math.toDegrees(convert_to_angle()+90))) );

    }

    public void Raquette_Bounce(){
        float test =  ((main.balle.pos_X - main.raquette.pos_X) / main.raquette.size_X) * 90;
        angle_to_speed((float)Math.toRadians( -135 + test));
    }

    public RectF  Draw(){
        RectF balle = new RectF(pos_X , pos_Y , pos_X + size_X , pos_Y+ size_Y);
        return balle;
    }
    public Boolean touch_side(){
        if(pos_X<0 || pos_X + size_X > main.width){
            return  true;
        }
        else {
            return  false;
        }
    }


    public Boolean touch_up(){
        if(pos_Y - size_Y < 0){
            return  true;
        }
        else {
            return  false;
        }

    }
    public Boolean in_screen(){
        if(pos_X>0 && pos_Y>0 && pos_X+ size_X < main.width && pos_Y + size_Y < main.height){
            return false;
        }
        return true;
    }
}
