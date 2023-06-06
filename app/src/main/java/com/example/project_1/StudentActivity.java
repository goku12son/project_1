package com.example.project_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_1.ExamResultDetails;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    ArrayList<ExamResultDetails> examResultDetailsList ;

    Button btnSolveExam,   btnEditInformation, btnViewRank,logoutButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        btnSolveExam = findViewById(R.id.btnSolveExam);
        btnEditInformation = findViewById(R.id.btnEditInformation);
        btnViewRank = findViewById(R.id.btnViewRank);
        logoutButton2=findViewById(R.id.logoutButton2);
        btnSolveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, ViewAllExamsActivity.class);
                startActivity(intent);

            }
        });
        btnEditInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, UpdatestudentdataActivity.class);
                startActivity(intent);

            }
        });

        btnViewRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                float percentage = sharedPreferences.getFloat("percentage", 0.0f);

                Intent intent = new Intent(StudentActivity.this, TopStudentsActivity.class);
                intent.putExtra("percentage", percentage);
                startActivity(intent);

            }
        });
        logoutButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}