package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTeacherActivity2 extends AppCompatActivity {
    Dbhelper databaseHelper;

    EditText editTextTeacherName;
    EditText editTextTeacherId;
    EditText editTextTeacherName2;
    EditText editTextTeacherDateOfBirth;
    EditText editTextTeacherGender;
    EditText editTeacherTextSalary;
    EditText editTeacherSpecialty;
    Button buttonAddTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher2);
        editTextTeacherName=findViewById(R.id.editTextTeacherName);
        editTextTeacherId=findViewById(R.id.editTextTeacherId);
        editTextTeacherName2=findViewById(R.id.editTextTeacherName2);
        editTextTeacherDateOfBirth=findViewById(R.id.editTextTeacherDateOfBirth);
        editTextTeacherGender=findViewById(R.id.editTextTeacherGender);
        editTeacherTextSalary=findViewById(R.id.editTeacherTextSalary);
        editTeacherSpecialty=findViewById(R.id.editTeacherSpecialty);
        buttonAddTeacher=findViewById(R.id.buttonAddTeacher);
        databaseHelper=new Dbhelper(this);

        buttonAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editTextTeacherName.getText().toString();
                String username=editTextTeacherName2.getText().toString();
                String id=editTextTeacherId.getText().toString();
                String date =editTextTeacherDateOfBirth.getText().toString();
                String gender =editTextTeacherGender.getText().toString();
                String specialty =editTeacherSpecialty.getText().toString();
                String Salary=editTeacherTextSalary.getText().toString();
                if (name.isEmpty()||username.isEmpty()||id.isEmpty()||date.isEmpty()||gender.isEmpty()||specialty.isEmpty()||Salary.isEmpty()){
                    Toast.makeText(AddTeacherActivity2.this, "يرجى تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
                }else {
                    int salary=Integer.parseInt(Salary);
                    Teacher teacher=new Teacher(name,username,id,date,specialty,gender,salary);
                    databaseHelper.addTeacher(teacher);
                    finish();
                }

            }
        });
    }
}