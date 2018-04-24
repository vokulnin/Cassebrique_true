package com.example.vokulnin.cassebrique;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CollFnac on 16/04/2018.
 */

public class Load extends AppCompatActivity {
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
        setContentView(R.layout.activity_score);
        List<Slot> test2 = new ArrayList<Slot>();
        ListAdapter2 test = new ListAdapter2(this , Save.ref.saves);

        list = findViewById(R.id.List);
        list.setAdapter(test);


    }


    public class ListAdapter2 extends ArrayAdapter<Slot> {

        private final Context context;
        public Load test;
        public ListAdapter2(Context context, List<Slot> values) {
            super(context, R.layout.test, values);
            this.context = context;
        }
        public void delete(){
            Intent intent = new Intent(Load.this , Game.class );
            startActivity(intent);
            Load.this.finish();
        }



        public View getView(final int position, View convertView, ViewGroup parent) {
            View cellView = convertView;

            if (cellView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cellView = inflater.inflate(R.layout.test, parent, false);
            }



            final Slot t = getItem(position);

            TextView levelView = (TextView) cellView.findViewById(R.id.Level);
            TextView scoreView = (TextView) cellView.findViewById(R.id.Score);
            TextView dateView = (TextView) cellView.findViewById(R.id.date);

            Button delete = (Button) cellView.findViewById(R.id.Delete);
            Button load = (Button) cellView.findViewById(R.id.Load);
            levelView.setText("level : " + Integer.toString( t.level));
            scoreView.setText("score : " + Integer.toString(t.score));
            dateView.setText(t.date );
            load.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Load.this.selectioned = t;
                    Load.this.load();

                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Save.ref.saves.remove(position);
                    list.invalidateViews();


                }
            });




            return cellView;
        }
    }
}
