package com.example.john.knowwoodboardapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by John on 08/04/2016.
 */
public class CreatingHangman extends View{
    Paint paint = new Paint();
    //TextView txtLives = (TextView)findViewById(R.id.txtLives);
    //String text = txtLives.getText().toString();

    DisplayMetrics lDisplayMetrics = getResources().getDisplayMetrics();


    public CreatingHangman(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //int lives = Integer.parseInt(text);
        int lives = 5;
        int width = lDisplayMetrics.widthPixels;
        int height = lDisplayMetrics.heightPixels;
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);

        if(lives <= 10){
            //Draw Base
            canvas.drawLine(width/4,height/3,width/2,height/3,paint);
        }
        if(lives <= 9){
            //Draw pillar
            canvas.drawLine(width/4,height/3,width/4,height/14,paint);
        }
        if(lives <= 8){
            //Draw top Horizontal line
            canvas.drawLine(width/4,height/14,width/2,height/14,paint);
        }
        if(lives <= 7){
            //Draw rope
            canvas.drawLine(width/2,height/14,width/2,height/10,paint);
        }
        if(lives <= 6){
            //Draw Head
            canvas.drawCircle(width/2,height/8,width/14,paint);
        }
        if(lives <= 5){
            //Draw Body
            canvas.drawLine(width/2,height/8,width/2,height/4,paint);
        }
        if(lives <= 4){
            //Draw Left arm
            canvas.drawLine(width/2,height/6,width/2-30,height/4,paint);
        }
        if(lives <= 3){
            //Draw Right Arm
            canvas.drawLine(width/2,height/6,width/2+30,height/4,paint);
        }
        if(lives <= 2){
            //Draw Left Leg
            canvas.drawLine(width/2,height/4,width/2-30,height/3-15,paint);
        }
        if(lives <= 1){
            //Draw Right leg end game
            canvas.drawLine(width/2,height/4,width/2+30,height/3-15,paint);
        }
    }
}
