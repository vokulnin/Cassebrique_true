package com.example.vokulnin.cassebrique;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ScoreSlot  implements Serializable , Comparable<ScoreSlot>{
    public String name;
    public int score;
    public String date = "no date";

    public ScoreSlot(String Name , int Score ){
        name = Name;
        score = Score;
        date = new Date().toString();
    }

    @Override
    public int compareTo(@NonNull ScoreSlot toSort) {
        if (score > toSort.score){
            return -1;
        }
        if (score < toSort.score){
            return 1;
        }
        return 0;
    }
}
