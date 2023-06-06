package com.example.project_1;

import java.io.Serializable;

public class ExamResultDetails implements Serializable {
    private Student student;
    private Question question;
    private String studentAnswer;
    private Answer correctAnswer;
    private int marks;
    public ExamResultDetails(Question question, String studentAnswer, Answer correctAnswer, int marks) {
        this.question = question;
        this.studentAnswer = studentAnswer;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public Student getStudent() {
        return student;
    }
}
