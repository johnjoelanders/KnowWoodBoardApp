package com.example.john.knowwoodboardapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighscoreActivity extends AppCompatActivity {

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        db = new DatabaseHandler(this);

        Cursor res = db.getAllData();

        if(res.getCount() == 0){
            displayHighscores("Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Name :"+ res.getString(1));
            buffer.append("Score :"+ res.getString(2)+"\n\n");

        }
        displayHighscores(buffer.toString());
    }

    public void displayHighscores(String Message){
        TextView textView = (TextView)findViewById(R.id.txtHighScore);
        textView.setText(Message);

    }
}
