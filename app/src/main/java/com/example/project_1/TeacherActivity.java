package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {
    ArrayList<ExamResultDetails> examResultDetailsList ;
     ArrayList<Question> questionList;
Dbhelper dbhelper;
  Button btnAddStudent;
  Button btnViewStudents;
     Button btnAddQuestion;
    Button btnEditQuestion;
  Button btnViewQuestions;
     Button btnAddExam;
     Button btnViewExams;
   Button btnViewStudentResult;
    Button logoutButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnViewStudents = findViewById(R.id.btnViewStudents);
        btnAddQuestion = findViewById(R.id.btnAddQuestion);
        btnEditQuestion = findViewById(R.id.btnEditQuestion);
        btnViewQuestions = findViewById(R.id.btnViewQuestions);
        btnAddExam = findViewById(R.id.btnAddExam);
        btnViewExams = findViewById(R.id.btnViewExams);
        btnViewStudentResult = findViewById(R.id.btnViewStudentResult);
        examResultDetailsList = new ArrayList<>();

        dbhelper=new Dbhelper(this);
        logoutButton1=findViewById(R.id.logoutButton1);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

        btnViewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, ViewStudents.class);
                startActivity(intent);            }
        });

        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, AddquestionsActivity.class);
                startActivity(intent);
            }
        });

        btnEditQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, ViewquestionActivity.class);
                startActivity(intent);
            }
        });

        btnViewQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, ViewquestionActivity.class);
                startActivity(intent);
            }
        });

        btnAddExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, AddExamActivity.class);
                startActivity(intent);            }
        });

        btnViewExams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, ViewAllExamsActivity.class);
                startActivity(intent);
            }
        });



        btnViewStudentResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TeacherActivity.this, TopStudentsActivity.class);
                startActivity(intent);
            }
        });

        logoutButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
