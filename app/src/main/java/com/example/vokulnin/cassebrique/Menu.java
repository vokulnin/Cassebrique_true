package com.example.vokulnin.cassebrique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by CollFnac on 10/04/2018.
 */

public class Menu extends AppCompatActivity {


    public TextView score;
    public TextView status;
    public Button restart;
    public Button menu;
    public Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test  = new Myview(this , this);
        //setContentView(test);
        setContentView(R.layout.activity_result);
        score = findViewById(R.id.score);
        int temp = getIntent().getExtras().getInt("score");
        score.setText( "score :" + Integer.toString(temp));
        restart = findViewById(R.id.retry);
    }


    public boolean onTouchEvent(MotionEvent e) {

        if(e.getAction() == MotionEvent.ACTION_MOVE){

        }

        return true;
    }
    public void onClick(View v) {
        if (v == restart) {
            Intent intent = new Intent(this, Game.class);
            //intent.putExtra("score" , gamestate.score);
            Log.d("button" , "button pressed");
            startActivity(intent);

        }
    }

}
