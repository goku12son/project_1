package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewquestionActivity extends AppCompatActivity implements QuestionsAdapter.onClickIteum {
    RecyclerView recyclerView;
    Dbhelper databaseHelper;
    QuestionsAdapter questionsAdapter;
    ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewquestion);

        recyclerView = findViewById(R.id.RecyclerView);
        databaseHelper = new Dbhelper(this);
        questionList = databaseHelper.getAllQuestion();

        questionsAdapter = new QuestionsAdapter(this, questionList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        questionList.clear();
        questionList.addAll(databaseHelper.getAllQuestion());
        questionsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(Question question) {
        Intent intent = new Intent(ViewquestionActivity.this, AddquestionsActivity.class);
        intent.putExtra("question", question);
        startActivity(intent);
    }
}
