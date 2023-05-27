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
        startActivityForResult(intent, 1);
    }

    public void addNewTeacher() {
        // Implement add new teacher functionality
    }

    public void viewStudents() {
        Intent intent = new Intent(AdminActivity.this, ViewStudents.class);
        intent.putExtra("studentArrayList", studentArrayList);
        startActivity(intent);
    }

    public void viewTeacher() {
        // Implement view teacher functionality
    }

    public void logoutAdmin() {
        Intent intent = new Intent(AdminActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                Student student = (Student) data.getSerializableExtra("student");
                if (student != null) {
                    studentArrayList.add(student);
                }
            }
        }
    }
}
