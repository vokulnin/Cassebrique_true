package com.example.vokulnin.cassebrique;

/**
 * Created by vokulnin on 28/03/2018.
 */

public class GameState {
    public Game main;
    public int score;
    public int Ball_left = 100;
    public int Brick_left;


    public GameState(Game Main){
        main = Main;
    }
    public void Ball_lost(){
        Ball_left -= 1;
        if(Ball_left>=0){
            main.balle.pos_Y = main.height/2;
            main.balle.pos_X = main.width/2;
            main.balle.speed_Y =4;
            main.balle.speed_X =0;
        }
    }

    public void GameOver(){

    }

    public void GameFinished(){

    }
}
