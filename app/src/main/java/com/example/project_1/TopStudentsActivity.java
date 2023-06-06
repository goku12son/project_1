package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TopStudentsActivity extends AppCompatActivity {
    ArrayList<Float> percentages;
   ArrayList<Float> topFivePercentages;
    TextView TopStudents;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_students);
        TopStudents=findViewById(R.id.TopStudents);
          dbhelper=new Dbhelper(this);
        float percentage = getIntent().getFloatExtra("percentage", 0.0f);
       /* percentages = new ArrayList<>();
        percentages.add(percentage);
        Collections.sort(percentages, Collections.reverseOrder());
        int topCount = Math.min(5, percentages.size());
        topFivePercentages = (ArrayList<Float>) percentages.subList(0, topCount);
       */


        TopStudents.setText(String.valueOf(percentage) +dbhelper.getAllStudent() );


    }
}