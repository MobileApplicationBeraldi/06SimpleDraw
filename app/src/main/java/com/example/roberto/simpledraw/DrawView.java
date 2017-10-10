package com.example.roberto.simpledraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;


import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by roberto on 15.11.2016.
 */

public class DrawView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();


    public DrawView(Context context) {
        super(context);

        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;

        }
        invalidate();
        return true;
    }
}
