package com.example.vokulnin.cassebrique;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CollFnac on 16/04/2018.
 */

public class Score extends AppCompatActivity {
    public ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ListAdapter test = new ListAdapter(this , Save.ref.saves);

        list = findViewById(R.id.List);
        list.setAdapter(test);


    }


}
