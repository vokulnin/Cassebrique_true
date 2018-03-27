package com.example.vokulnin.cassebrique;

/**
 * Created by vokulnin on 25/03/2018.
 */

public class Brick {
    public Game main;
    public float size_X ;
    public float size_Y ;
    public float pos_X ;
    public float pos_Y ;



    public Brick(Game Main){
        main = Main;

        size_X = main.width * 0.1f;
        size_Y = main.width * 0.1f;
        pos_X = main.width * 0.5f;
        pos_Y = main.height * 0.5f;
    }

}
