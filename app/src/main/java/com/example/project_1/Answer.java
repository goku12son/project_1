package com.example.project_1;


import java.io.Serializable;
import java.util.ArrayList;

public class Answer implements Serializable {
    private ArrayList<String> options;
    private String userAnswer;

    public Answer(ArrayList<String> options, String userAnswer) {
        this.options = options;
        this.userAnswer = userAnswer;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
