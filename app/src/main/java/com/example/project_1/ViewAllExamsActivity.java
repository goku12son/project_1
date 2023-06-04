package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewAllExamsActivity extends AppCompatActivity {
RecyclerView recyclerviewExam;
    Dbhelper databaseHelper;
    ArrayList<Exam> examArrayList;
     ExamAdapter examAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_exams);
        recyclerviewExam=findViewById(R.id.recyclerviewExam);
        databaseHelper = new Dbhelper(this);
        examArrayList=databaseHelper.getExams();
        examAdapter=new ExamAdapter(examArrayList, this);
        recyclerviewExam.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewExam.setAdapter(examAdapter);

    }
}