package com.example.vokulnin.cassebrique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by CollFnac on 10/04/2018.
 */

public class Result extends AppCompatActivity {


    public TextView score;
    public TextView status;
    public EditText name;

    public Button restart;
    public Button menu;
    public Button quit;
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test  = new Myview(this , this);
        //setContentView(test);
        setContentView(R.layout.activity_result);
        score = findViewById(R.id.score);
        status = findViewById(R.id.status);
        quit = findViewById(R.id.quit);
        menu = findViewById(R.id.menu);
        name = findViewById(R.id.name);
        save = findViewById(R.id.save);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save.ref.scores.add(new ScoreSlot(name.getText().toString(),getIntent().getExtras().getInt("score")));
                Save.ref.saveScores();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        int temp = getIntent().getExtras().getInt("score");
        score.setText( "score :" + Integer.toString(temp));
        if(getIntent().getExtras().getBoolean("Won")){
            status.setText("You WON");
        }
        restart = findViewById(R.id.retry);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });
    }



    public void restart(){
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("load" , false);

        //intent.putExtra("score" , gamestate.score);
        startActivity(intent);
    }

    public void menu(){
        Intent intent = new Intent(this, Menu.class);
        //intent.putExtra("score" , gamestate.score);
        startActivity(intent);
    }

    public void onClick(View v) {
        status.setText("pressed");

        if (v == restart) {
            Intent intent = new Intent(this, Game.class);
            //intent.putExtra("score" , gamestate.score);
            Log.d("button" , "button pressed");
            status.setText("pressed2");
            startActivity(intent);

        }
    }

}
