package com.example.john.knowwoodboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmitOnClick();

            }
        });
    }

    private String hideWord(String wordToGuess) {
        String wordToGuessHidden = "";
        return wordToGuessHidden;
    }

    private void btnSubmitOnClick() {

    }

    private String formatArraylistToString(List<String> listToFormat) {
        return listToFormat.toString()
                .replace(",", " ")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }


}
