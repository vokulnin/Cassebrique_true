package com.example.vokulnin.cassebrique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Menu extends AppCompatActivity {
            public Button start;
            public Button load;
            public Button score;
            public Button quit;



    public void Start(){
        Intent intent = new Intent(this , Game.class );
        startActivity(intent);
        this.finish();
    }
    public void Load(){
        Intent intent = new Intent(this , Game.class );
        startActivity(intent);
        this.finish();
    }
    public void Score(){
        Intent intent = new Intent(this , Score.class );
        startActivity(intent);
        this.finish();
    }

    public void Exit(){
        System.exit(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Save.context = this.getApplicationContext();
        Save.ref = new Save();
        start = findViewById(R.id.New);
        load = findViewById(R.id.Load);
        score = findViewById(R.id.Score);
        quit = findViewById(R.id.Quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exit();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start();
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score();
            }
        });

    }
}