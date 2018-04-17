package com.example.vokulnin.cassebrique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by CollFnac on 16/04/2018.
 */

public class Score extends AppCompatActivity {
    public ListView list;
    public Slot selectioned;
    public void load(){
        Intent intent = new Intent(this , Game.class );
        startActivity(intent);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        List<Slot> test2 = new ArrayList<Slot>();
        ListAdapter test = new ListAdapter(this , Save.ref.saves);

        list = findViewById(R.id.List);
        list.setAdapter(test);


    }


}
