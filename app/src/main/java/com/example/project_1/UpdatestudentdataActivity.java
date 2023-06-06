package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatestudentdataActivity extends AppCompatActivity {
EditText editTextPassword,editTextUsername,editTextbirthdate;
Button buttonUpdate;
Dbhelper dbhelper;
Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatestudentdata);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextbirthdate = findViewById(R.id.editTextbirthdate);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        dbhelper = new Dbhelper(this);
        student = new Student();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String birthdate = editTextbirthdate.getText().toString();
                if (username.isEmpty() || password.isEmpty() || birthdate.isEmpty()) {
                    Toast.makeText(UpdatestudentdataActivity.this, "الرجاء إدخال جميع القيم", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isSave = dbhelper.updateStudent(student.getUniversityid(),username,password,birthdate);
                    if (!isSave) {
                        Toast.makeText(UpdatestudentdataActivity.this, "تم التعديل", Toast.LENGTH_SHORT).show();
                        finish();


                    } else {
                        Toast.makeText(UpdatestudentdataActivity.this, "فشل في تعديل الطالب", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }}