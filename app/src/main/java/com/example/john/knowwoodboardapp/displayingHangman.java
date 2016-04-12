package com.example.john.knowwoodboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class displayingHangman extends AppCompatActivity {
    CreatingHangman creatingHangman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_hangman);
        creatingHangman = new CreatingHangman(this);
        setContentView(creatingHangman);

    }
}
