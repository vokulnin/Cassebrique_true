package com.example.vokulnin.cassebrique;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by CollFnac on 17/04/2018.
 */

public class Slot  implements Serializable  {
    public String name;
    public List<Brick> bricks;
    public int level;
    public int score;
    public int ball_left;
    public String date = "no date";

    public Slot(String Name , List<Brick> Bricks , int Level , int Score , int Ball_left){
        name = Name;
        bricks = Bricks;
        level = Level;
        score = Score;
        ball_left = Ball_left;
       date = new Date().toString();
    }
}
