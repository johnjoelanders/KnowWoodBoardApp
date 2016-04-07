package com.example.john.knowwoodboardapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LBluett on 07/04/16.
 */
public class ValidateGame {

    private List<String> usedLetters;
    private List<String> validLetters;

    public ValidateGame(String validWord) {
        this.usedLetters = new ArrayList<String>();
        this.validLetters = new ArrayList<String>(Arrays.asList(validWord.split("")));
    }

    public boolean isLetterUsed(String letterInputted) {
        if(this.usedLetters.contains(letterInputted)) {
            return true;
        }
        else {
            this.usedLetters.add(letterInputted);
            return false;
        }
    }

    public boolean isLetterValid(String letterInputted) {
        return this.validLetters.contains(letterInputted);
    }

    public List<String> getUsedLetters() {
        return usedLetters;
    }

    public void setUsedLetters(List<String> usedLetters) {
        this.usedLetters = usedLetters;
    }

    public List<String> getValidLetters() {
        return validLetters;
    }

    public void setValidLetters(List<String> validLetters) {
        this.validLetters = validLetters;
    }
}
