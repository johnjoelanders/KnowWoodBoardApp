package com.example.john.knowwoodboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Button btnSubmit;
    TextView hiddenWord, incorrectLetters;
    EditText submittedLetter;
    GameHandler gameHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hiddenWord =  (TextView) findViewById(R.id.txtWord);
        incorrectLetters = (TextView) findViewById(R.id.txtIncorrectLetters);
        submittedLetter = (EditText) findViewById(R.id.txtEnterLetter);

        this.hiddenWord.setText("");

        String wordToGuess = wordToGuess();

        gameHandler = new GameHandler(
                10,
                formatStringToArraylist(wordToGuess),
                formatStringToArraylist(hideWord(wordToGuess))
        );

        this.btnSubmit=(Button)findViewById(R.id.btnSubmit);
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmitOnClick(submittedLetter.getText().toString());
                submittedLetter.setText("");
                hiddenWord.setText(formatArraylistToString(gameHandler.getUpdatedHiddenWord()));
                incorrectLetters.setText(formatArraylistToString(gameHandler.getWrongLetters()));
            }
        });
    }

    private String hideWord(String wordToGuess) {
        String wordToGuessHidden = "";
        for(int i = 0; i < wordToGuess.length(); i++) {
            wordToGuessHidden += "-";
        }
        return wordToGuessHidden;
    }

    private String formatArraylistToString(List<String> listToFormat) {
        return listToFormat.toString()
                .replace(",", " ")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }

    private List<String> formatStringToArraylist(String stringToFormat) {
        String[] strValues = stringToFormat.split("");
        return new ArrayList<String>(Arrays.asList(strValues));
    }

    private String wordToGuess() {
        return "tree";
    }

    private void btnSubmitOnClick(String letterSubmitted) {
        if(!gameHandler.isLetterUsed(letterSubmitted)) {
            gameHandler.addUsedLetter(letterSubmitted);
            if(gameHandler.isLetterInWordToGuess(letterSubmitted)) {
                gameHandler.addCorrectLetterToHiddenWord(letterSubmitted);
            } else {
                gameHandler.addWrongLetter(letterSubmitted);
            }
        }
    }
}
