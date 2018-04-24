package com.example.vokulnin.cassebrique;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Score extends AppCompatActivity {
    public ListView list;
    public Slot selectioned;
    public void load(){
        Intent intent = new Intent(this , Game.class );
        intent.putExtra("info" , selectioned);
        intent.putExtra("load" , true);

        startActivity(intent);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score2);
        List<Slot> test2 = new ArrayList<Slot>();
        ListAdapter2 test = new ListAdapter2(this , Save.ref.scores);

        list = findViewById(R.id.List);
        list.setAdapter(test);


    }


    public class ListAdapter2 extends ArrayAdapter<ScoreSlot> {

        private final Context context;
        public Load test;

        public ListAdapter2(Context context, List<ScoreSlot> values) {
            super(context, R.layout.scoreslot, values);
            this.context = context;
        }
        public void delete(){
            Intent intent = new Intent(Score.this , Game.class );
            startActivity(intent);
            Score.this.finish();
        }



        public View getView(final int position, View convertView, ViewGroup parent) {
            View cellView = convertView;

            if (cellView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cellView = inflater.inflate(R.layout.scoreslot, parent, false);
            }



            final ScoreSlot t = getItem(position);

            TextView nameView = (TextView) cellView.findViewById(R.id.name);
            TextView scoreView = (TextView) cellView.findViewById(R.id.score);

            scoreView.setText("score : " + Integer.toString(t.score));
            nameView.setText(t.name);






            return cellView;
        }
    }
}
