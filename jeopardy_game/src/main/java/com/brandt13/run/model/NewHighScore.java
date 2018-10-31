package com.brandt13.run.model;

public class NewHighScore {

    int newHigh = 0;

    public NewHighScore(int newHigh) {
        this.newHigh = newHigh;
    }

    public NewHighScore() {
    }

    public int getNewHigh() {
        return newHigh;
    }

    public void setNewHigh(int newHigh) {
        this.newHigh = newHigh;
    }
}
