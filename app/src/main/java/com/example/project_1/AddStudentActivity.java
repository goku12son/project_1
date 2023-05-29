package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextStudentId;
    EditText editTextName2;
    EditText editTextDateOfBirth;
    EditText editTexuniversityid;
    EditText editTextGender;
    Button buttonAdd;
    Dbhelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextName2=findViewById(R.id.editTextName2);
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
        editTexuniversityid = findViewById(R.id.editTexuniversityid);
        editTextGender = findViewById(R.id.editTextGender);
        buttonAdd = findViewById(R.id.buttonAddStudent);
          databaseHelper=new Dbhelper(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String studentId = editTextStudentId.getText().toString();
                String name2 = editTextName2.getText().toString();
                String dateOfBirth = editTextDateOfBirth.getText().toString();
               String universityid =editTexuniversityid.getText().toString();
                String gender = editTextGender.getText().toString();

                if (name.isEmpty() || studentId.isEmpty() || dateOfBirth.isEmpty() || gender.isEmpty()||universityid.isEmpty()) {
                    Toast.makeText(AddStudentActivity.this, "يرجى تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
                } else {
                    Student student = new Student(name, studentId,name2 ,dateOfBirth, universityid, gender);
                     databaseHelper.addStudent(student);
                    Toast.makeText(AddStudentActivity.this, "تمت العملية بنجاح", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }}



