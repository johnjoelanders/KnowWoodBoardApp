package com.example.john.knowwoodboardapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by John on 08/04/2016.
 */
public class CreatingHangman extends View{
    Paint paint = new Paint();
    public CreatingHangman(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        canvas.drawLine(50,0,60,100,paint);
    }
}
