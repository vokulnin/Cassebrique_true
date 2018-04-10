package com.example.vokulnin.cassebrique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

public class Myview extends View {

    public Game main;
    public Boolean first_frame = true;
    public Myview(Context context , Game Main) {
        super(context);
       main = Main;
    }


    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Myview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if(first_frame){
            first_frame = false;
        }
        else {
            if (main.generated) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.GRAY);
                Log.d("canvas", Integer.toString(canvas.getWidth()));
                Log.d("canvas", Integer.toString((int) main.raquette.pos_X));

                canvas.drawRect(main.raquette.Draw(), paint);
                canvas.drawRect(main.balle.Draw(), paint);
                for (int i = 0; i < main.bricks.size(); i++) {
                    canvas.drawRect(main.bricks.get(i).Draw(), paint);
                }
            }
        }
    }

}