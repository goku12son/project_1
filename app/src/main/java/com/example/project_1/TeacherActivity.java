package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherActivity extends AppCompatActivity {

  Button btnAddStudent;
  Button btnViewStudents;
     Button btnAddQuestion;
    Button btnEditQuestion;
  Button btnViewQuestions;
     Button btnAddExam;
     Button btnViewExams;
     Button btnViewExamResults;
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
        btnViewExamResults = findViewById(R.id.btnViewExamResults);
        btnViewStudentResult = findViewById(R.id.btnViewStudentResult);
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

        btnViewExamResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // عرض نتائج الامتحان
            }
        });

        btnViewStudentResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // عرض نتيجة الطالب
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
