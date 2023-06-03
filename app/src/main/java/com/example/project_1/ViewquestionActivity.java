package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewquestionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Dbhelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewquestion);
        recyclerView=findViewById(R.id.RecyclerView);
        databaseHelper=new Dbhelper(this);

        ArrayList<Question>questionList=databaseHelper.getAllQuestion();
        QuestionsAdapter questionsAdapter = new QuestionsAdapter(this, questionList, new QuestionsAdapter.onClickIteum() {
            @Override
            public void onClick(Question question) {
                Intent intent = new Intent(ViewquestionActivity.this, AddquestionsActivity.class);
              intent.putExtra("question",question);
                startActivity(intent);

            }
        });
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionsAdapter);

    }
}