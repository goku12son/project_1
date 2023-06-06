package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamResultDetailsActivity extends AppCompatActivity {
    private RecyclerView resultDetailsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_details);

        resultDetailsRecyclerView = findViewById(R.id.RecyclerView);

        Intent intent = getIntent();
        ArrayList<ExamResultDetails> examResultDetailsList = (ArrayList<ExamResultDetails>) intent.getExtras().getSerializable("examResultDetailsList");
        ArrayList<Question> questionList = (ArrayList<Question>) intent.getExtras().getSerializable("questionList");

        if (examResultDetailsList != null && !examResultDetailsList.isEmpty()) {
            ResultAdapter resultAdapter = new ResultAdapter(this, examResultDetailsList);
            resultDetailsRecyclerView.setAdapter(resultAdapter);
            resultDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
