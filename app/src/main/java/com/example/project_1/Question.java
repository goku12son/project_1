package com.example.project_1;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String questionText;
    private double marksWeight;
    private boolean answer;

    public Question(int id, String questionText, double marksWeight, boolean answer) {
        this.id = id;
        this.questionText = questionText;
        this.marksWeight = marksWeight;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public double getMarksWeight() {
        return marksWeight;
    }

    public boolean getAnswer() {
        return answer;
    }

    public boolean isAnswer() {
        return answer;
    }
}
