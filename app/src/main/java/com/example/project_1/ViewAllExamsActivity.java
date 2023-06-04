package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAllExamsActivity extends AppCompatActivity {
    RecyclerView recyclerViewExam;
    ArrayList<Exam> examList;
    ExamAdapter examAdapter;
    Dbhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_exams);

        recyclerViewExam = findViewById(R.id.recyclerviewExam);
        recyclerViewExam.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new Dbhelper(this);
        examList = dbHelper.getExams();
        examAdapter = new ExamAdapter(examList, this, new ExamAdapter.onClickIteum() {
            @Override
            public void onClick(Exam exam) {
                Intent intent = new Intent(ViewAllExamsActivity.this, SolveExamActivity.class);
                intent.putExtra("exam", exam);
                startActivity(intent);
            }
        });
        recyclerViewExam.setAdapter(examAdapter);
    }

}
