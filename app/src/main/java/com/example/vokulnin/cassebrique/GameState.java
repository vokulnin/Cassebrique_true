package com.example.vokulnin.cassebrique;

import android.content.Intent;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by vokulnin on 28/03/2018.
 */

public class GameState {
    public Game main;
    public int score;
    public int Ball_left = 3;
    public int Brick_left;
    public int level = 0;

    public GameState(Game Main){
        main = Main;
    }
    public void Ball_lost(){

        Ball_left -= 1;
        if(Ball_left>=0){
            main.balle.pos_Y = main.height/2;
            main.balle.pos_X = main.width/2;
           // main.balle.speed_Y =15f;
            //main.balle.speed_X =4;
        }
        else {
            GameOver();
        }
        main.running = false;

    }

    public void GameOver(){
    main.chargeScore(false);
    }

    public void GameFinished(){
        switch (level){
            case(0):
            main.generator.setLevel(5,2);
            main.generator.Generate();
            main.running = false;
            break;
            case(1):
                main.generator.setLevel(4,5);
                main.generator.Generate();
                main.running = false;

                break;
            case(6):
                main.generator.setLevel(5,5);
                main.generator.Generate();
                main.running = false;

                break;
                default:
                    main.chargeScore(true);
                    break;



        }
        level +=1;
    }
}
