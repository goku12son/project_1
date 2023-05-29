package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewTeacherActivity2 extends AppCompatActivity {
    Dbhelper databaseHelper;
    ArrayList<Teacher>teacherList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teacher2);
        ListView listView=findViewById(R.id.listView_teacher);
        databaseHelper=new Dbhelper(this);

        teacherList = databaseHelper.getAllTeacher();
        CustomAdapterTeacher adapter=new CustomAdapterTeacher(this,teacherList);
        listView.setAdapter(adapter);


    }
}