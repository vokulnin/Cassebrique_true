package com.example.vokulnin.cassebrique;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by CollFnac on 17/04/2018.
 */

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
        return score;
    }
}
