package com.example.john.knowwoodboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private String[] sampleArray = {"hello", "johnjoe", "and adele", "its me"};
    private int lives = 10;
    private Button btnSubmit;
    private EditText txtGuess;
    private String wordToGuess;
    private String initialCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView txtLives =(TextView)findViewById(R.id.txtLives);
        txtLives.setText(""+lives);

        int index = getRandomNumberForArrayIndex(sampleArray.length);
        wordToGuess = getWordToGuess(index);
        initialCharacters = hideWord(wordToGuess);
        TextView txtWord = (TextView)findViewById(R.id.txtWord);
        txtWord.setText(initialCharacters);


        btnSubmit=(Button)findViewById(R.id.btnPlay);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { btnSubmitOnClick(); }
        });
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

    private void btnSubmitOnClick() {
        txtGuess = (EditText) findViewById(R.id.txtEnterLetter);
        String guess = txtGuess.getText().toString();
        char [] hiddenWord = convertStringToCharArray(initialCharacters);

        for(int i = 0; i < guess.length(); i++) {
            String charToCheck = guess.substring(i, (i + 1));
            for(int j = 0; j < wordToGuess.length(); i++) {
                if(charToCheck.equals(wordToGuess.substring(j, (j + 1)))) {
                    hiddenWord[j] = charToCheck.charAt(i);
                }
            }
        }

        initialCharacters = convertCharArrayToString(hiddenWord);
        txtGuess.setText(initialCharacters);
    }

    private char[] convertStringToCharArray(String stringOfCharactors) {
        char [] charArray = new char[stringOfCharactors.length()];
        for(int i = 0; i < stringOfCharactors.length(); i++) {
            charArray[i] = stringOfCharactors.charAt(i);
        }

        return charArray;
    }

    private String convertCharArrayToString(char [] charArray) {
        String newString = "";
        for(int i = 0; i < charArray.length; i++) {
            newString += charArray[i];
        }

        return newString;
    }
}
