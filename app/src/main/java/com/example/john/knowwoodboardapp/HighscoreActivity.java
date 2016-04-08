package com.example.john.knowwoodboardapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HighscoreActivity extends AppCompatActivity {

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        db = new DatabaseHandler(this);

        Cursor res = db.getAllData();
        /*db.insertData("Luke ", 1);
        db.insertData("Luke ", 2);
        db.insertData("Luke ", 3);
        db.insertData("Luke ", 4);
        db.insertData("Luke ", 5);
        db.insertData("Luke ", 6);
        db.insertData("Luke ", 7);
        db.insertData("Luke ", 8);
        db.insertData("Luke ", 10);
        db.insertData("JJ ", 10);
        db.insertData("Luke ", 11);
        db.insertData("Luke ", 12);*/


        if(res.getCount() == 0){
            displayHighscores("Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Name :"+ res.getString(1)+"  ");
            buffer.append("Score :"+ res.getString(2)+"\n\n");

        }
        displayHighscores(buffer.toString());
    }

    public void displayHighscores(String Message){
        TextView textView = (TextView)findViewById(R.id.txtHighScore);
        textView.setText(Message);

    }
}
