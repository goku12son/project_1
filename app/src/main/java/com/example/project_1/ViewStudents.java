package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewStudents extends AppCompatActivity {
    ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

           ListView listView_student = findViewById(R.id.listView_student);

           Intent intent = getIntent();
        studentArrayList = (ArrayList<Student>) intent.getSerializableExtra("studentArrayList");

            CustomAdapterStudent adapter = new CustomAdapterStudent(this, studentArrayList);
            listView_student.setAdapter(adapter);
    }
}