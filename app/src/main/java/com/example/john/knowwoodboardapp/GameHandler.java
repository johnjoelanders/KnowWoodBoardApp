package com.example.john.knowwoodboardapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LBluett on 13/04/16.
 */
public class GameHandler {

    int livesLeft;
    List<String> wordToGuess, wordToGuessHidden,lettersUsed, wrongLetters;

    public GameHandler(int maxNumberOfLives, List<String> wordToGuess, List<String> wordToGuessHidden) {
        this.livesLeft = maxNumberOfLives;
        this.wordToGuess = wordToGuess;
        this.wordToGuessHidden = wordToGuessHidden;
        this.lettersUsed = new ArrayList<String>();
        this.wrongLetters = new ArrayList<String>();
    }

    public boolean isLetterUsed(String letter) {
        return this.lettersUsed.contains(letter);
    }

    public boolean isLetterInWordToGuess(String letter) {
        return this.wordToGuess.contains(letter);
    }

    public void lifeLost() {
        this.livesLeft -= 1;
    }

    public void addUsedLetter(String letter) {
        this.lettersUsed.add(letter);
    }

    public void addWrongLetter(String letter) {
        this.wrongLetters.add(letter);
    }

    public void addCorrectLetterToHiddenWord() {

    }

    public List<String> getWrongLetters() {
        return wrongLetters;
    }
}
