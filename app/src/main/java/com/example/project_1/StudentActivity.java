package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends AppCompatActivity {
   Button btnSolveExam, btnExamResults, btnExamResultDetails, btnEditInformation, btnViewRank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        btnSolveExam = findViewById(R.id.btnSolveExam);
        btnExamResults = findViewById(R.id.btnExamResults);
        btnExamResultDetails = findViewById(R.id.btnExamResultDetails);
        btnEditInformation = findViewById(R.id.btnEditInformation);
        btnViewRank = findViewById(R.id.btnViewRank);

        btnSolveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, ViewAllExamsActivity.class);
                startActivity(intent);

            }
        });
    }
}