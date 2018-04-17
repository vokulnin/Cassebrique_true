package com.example.vokulnin.cassebrique;

/**
 * Created by CollFnac on 17/04/2018.
 */


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by etiennepayet on 27/03/2018.
 */

public class ListAdapter extends ArrayAdapter<Slot> {

    private final Context context;

    public ListAdapter(Context context, List<Slot> values) {
        super(context, R.layout.test, values);
        this.context = context;
    }
    public void delete(){

    }



    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;

        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.test, parent, false);
        }




        TextView levelView = (TextView) cellView.findViewById(R.id.Level);
        TextView scoreView = (TextView) cellView.findViewById(R.id.Score);
        Button delete = (Button) cellView.findViewById(R.id.Delete);
        Button load = (Button) cellView.findViewById(R.id.Load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Slot t = getItem(position);
        levelView.setText(Integer.toString( t.level));
        scoreView.setText(Integer.toString(t.score));


        return cellView;
    }
}
