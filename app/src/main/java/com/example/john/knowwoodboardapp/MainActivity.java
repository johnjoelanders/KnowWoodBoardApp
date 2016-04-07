package com.example.john.knowwoodboardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//blah
public class MainActivity extends AppCompatActivity {

    Button button;
    DatabaseHandler myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHandler(this);

        button=(Button)findViewById(R.id.btnPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(gameActivity);
            }
        });
    }
}
