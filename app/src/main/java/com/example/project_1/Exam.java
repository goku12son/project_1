package com.example.project_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Exam implements Serializable {
    private int id;
    private String name;
    private int numberOfQuestions;
    private double minPassAverage;
    private int totalMarks;
    private String allowedQuestionType;
    private ArrayList<Question> questions;
    public Exam(){}
    public Exam( String name, int numberOfQuestions, double minPassAverage, int totalMarks, String allowedQuestionType, ArrayList<Question> questions) {

        this.name = name;
        this.numberOfQuestions = numberOfQuestions;
        this.minPassAverage = minPassAverage;
        this.totalMarks = totalMarks;
        this.allowedQuestionType = allowedQuestionType;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public double getMinPassAverage() {
        return minPassAverage;
    }

    public void setMinPassAverage(double minPassAverage) {
        this.minPassAverage = minPassAverage;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getAllowedQuestionType() {
        return allowedQuestionType;
    }

    public void setAllowedQuestionType(String allowedQuestionType) {
        this.allowedQuestionType = allowedQuestionType;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
