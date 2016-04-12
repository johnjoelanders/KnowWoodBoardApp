package com.example.john.knowwoodboardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//blah
public class MainActivity extends AppCompatActivity {

    Button btnPlay,btnHighScore,btnHangman;
    DatabaseHandler myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHandler(this);

        btnPlay=(Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(gameActivity);
            }
        });

        btnHighScore=(Button)findViewById(R.id.btnHighScore);
        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(getApplicationContext(),HighscoreActivity.class);
                startActivity(gameActivity);

            }
        });

        btnHangman=(Button)findViewById(R.id.btnHangman);
        btnHangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(getApplicationContext(),displayingHangman.class);
                startActivity(gameActivity);

            }
        });



    }
}
