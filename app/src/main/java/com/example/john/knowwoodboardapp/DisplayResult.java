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

    public void updateHiddenWord(String letterToShow) {
        for(int i = 0; i < wordToGuess.size(); i++) {
            if (wordToGuess.get(i).equals(letterToShow)) {
                wordToGuessHidden.set(i, letterToShow);
            }
        }
    }

    public List<String> getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(List<String> wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public List<String> getWordToGuessHidden() {
        return wordToGuessHidden;
    }

    public void setWordToGuessHidden(List<String> wordToGuessHidden) {
        this.wordToGuessHidden = wordToGuessHidden;
    }

    public List<String> getIncorrectUsedLetters() {
        return incorrectUsedLetters;
    }

    public void setIncorrectUsedLetters(List<String> incorrectUsedLetters) {
        this.incorrectUsedLetters = incorrectUsedLetters;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }
}
