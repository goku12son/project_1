package com.example.project_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private int questionId;
    private String questionText;
    private double marksWeight;
    private Answer answer;

    public Question(int questionId, String questionText, double marksWeight, Answer answer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.marksWeight = marksWeight;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public double getMarksWeight() {
        return marksWeight;
    }

    public void setMarksWeight(double marksWeight) {
        this.marksWeight = marksWeight;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
