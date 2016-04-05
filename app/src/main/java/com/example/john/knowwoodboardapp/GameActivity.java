package com.example.john.knowwoodboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private String[] sampleArray = {"hello", "johnjoe", "and adele", "its me"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int index = getRandomNumberForArrayIndex(sampleArray.length);
        String wordToGuess = getWordToGuess(index);
        String initialCharacters = hideWord(wordToGuess);
        TextView txtWord = (TextView)findViewById(R.id.txtWord);
        txtWord.setText(initialCharacters);
    }

    private int getRandomNumberForArrayIndex(int range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }

    private String getWordToGuess(int index) {
        return sampleArray[index];
    }

    private String hideWord(String wordToGuess) {
        String wordToGuessHidden = "";
        for(int i = 0; i < wordToGuess.length(); i++) {
            if(wordToGuess.substring(i,(i+1)).equals(" ")) {
                wordToGuessHidden += "   ";
            } else {
                wordToGuessHidden += "- ";
            }
        }
        return wordToGuessHidden;
    }
}
