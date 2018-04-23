package com.example.vokulnin.cassebrique;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by CollFnac on 11/04/2018.
 */

public class Save implements Serializable {
    public Game main ;
    public static Save ref;
    public static Context context;
    public  List<Slot> saves;
    public  List<ScoreSlot> scores;

    public Slot test;
    public Boolean saved = false;
    public Save(){

        if(Load() == null){
            saves = new ArrayList<Slot>();
        }
        else{
            saves = Load();
        }
        if(LoadScore() == null){
            scores = new ArrayList<ScoreSlot>();
        }
        else{
            scores = LoadScore();
        }

    }
    public void saveObject() {
        File file = new File(context.getFilesDir(), "saves");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)); //Select where you wish to save the file...
            oos.writeObject(saves); // write the class as an 'object'
            saved = true;

        } catch (Exception exr) {
            exr.printStackTrace();
        }
    }

    public void saveScores() {
        File file = new File(context.getFilesDir(), "scores");

        try {
            Collections.sort(scores);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)); //Select where you wish to save the file...
            oos.writeObject(scores); // write the class as an 'object'
            saved = true;

        } catch (Exception exr) {
            exr.printStackTrace();
        }
    }

    public List<Slot>  Load ()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(context.getFilesDir(), "saves")));
            List<Slot> o = (List<Slot>)ois.readObject();

            return o;
        }
        catch(Exception exw)
        {
            exw.printStackTrace();
        }
        return null;
    }

    public List<ScoreSlot>  LoadScore ()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(context.getFilesDir(), "scores")));
            List<ScoreSlot> o = (List<ScoreSlot>)ois.readObject();

            return o;
        }
        catch(Exception exw)
        {
            exw.printStackTrace();
        }
        return null;
    }
}