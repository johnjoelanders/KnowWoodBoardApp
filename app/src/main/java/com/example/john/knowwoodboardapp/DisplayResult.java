package com.example.john.knowwoodboardapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LBluett on 07/04/16.
 */
public class DisplayResult {

    private List<String> wordToGuess;
    private List<String> wordToGuessHidden;
    private List<String> incorrectUsedLetters;
    private int attemptsLeft;

    public DisplayResult(ArrayList<String> wordToGuess) {
        this.wordToGuess = wordToGuess;
        incorrectUsedLetters = new ArrayList<String>();
        attemptsLeft = 10;
        wordToGuessHidden = hideWordWithDashes(wordToGuess);
    }

    public ArrayList<String> hideWordWithDashes(ArrayList<String> wordToGuess) {
        ArrayList<String> hiddenWord = new ArrayList<String>();
        for(String i : wordToGuess) {
            if(i.equals(" ")) {
                hiddenWord.add("   ");
            } else {
                hiddenWord.add("-");
            }
        }
        return hiddenWord;
    }
}
