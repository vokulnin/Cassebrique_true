package com.example.vokulnin.cassebrique;

/**
 * Created by CollFnac on 17/04/2018.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etiennepayet on 27/03/2018.
 */

public class ListAdapter extends ArrayAdapter<Slot> {

    private final Context context;

    public ListAdapter(Context context, List<Slot> values) {
        super(context, R.layout.test, values);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;

        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.test, parent, false);
        }

        TextView levelView = (TextView) cellView.findViewById(R.id.level);
        TextView scoreView = (TextView) cellView.findViewById(R.id.score);
        ImageView imageView = (ImageView) cellView.findViewById(R.id.image);

        Slot t = getItem(position);
        levelView.setText(t.level);
        scoreView.setText(t.score);


        return cellView;
    }
}
