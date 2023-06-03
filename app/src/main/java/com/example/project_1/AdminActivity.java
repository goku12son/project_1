package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList;

    Button addStudent;
    Button viewStudents;
    Button logoutButton;
    Button addTeacher;
    Button viewTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addStudent = findViewById(R.id.addStudent);
        viewStudents = findViewById(R.id.viewStudents);
        addTeacher = findViewById(R.id.addTeacher);
        viewTeacher = findViewById(R.id.viewTeacher);
        logoutButton = findViewById(R.id.logoutButton);

        studentArrayList = new ArrayList<>();

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewStudent();
            }
        });

        viewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStudents();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutAdmin();
            }
        });

        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTeacher();
            }
        });

        viewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTeacher();
            }
        });
    }

    public void addNewStudent() {
        Intent intent = new Intent(AdminActivity.this, AddStudentActivity.class);
        startActivity(intent);
    }

    public void addNewTeacher() {
        Intent intent = new Intent(AdminActivity.this, AddTeacherActivity2.class);
        startActivity(intent);    }

    public void viewStudents() {
        Intent intent = new Intent(AdminActivity.this, ViewStudents.class);
        startActivity(intent);
    }

    public void viewTeacher() {
        Intent intent = new Intent(AdminActivity.this, ViewTeacherActivity2.class);
        startActivity(intent);
    }

    public void logoutAdmin() {
        Intent intent = new Intent(AdminActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}
