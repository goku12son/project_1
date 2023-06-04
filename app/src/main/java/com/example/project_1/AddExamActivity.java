package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddExamActivity extends AppCompatActivity {
    EditText etNumberOfQuestions, etMinPassAverage, etAllowedQuestionType,  etExamName, etTotalMarks;
    Button btnCreateExam;
    Dbhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);
        etNumberOfQuestions = findViewById(R.id.etNumberOfQuestions);
        etMinPassAverage = findViewById(R.id.etMinPassAverage);
        etExamName = findViewById(R.id.etExamName);
        etTotalMarks = findViewById(R.id.etTotalMarks);
        etAllowedQuestionType = findViewById(R.id.etAllowedQuestionType);
        btnCreateExam = findViewById(R.id.btnCreateExam);
        dbHelper = new Dbhelper(this);
        btnCreateExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberOfQuestionsStr = etNumberOfQuestions.getText().toString();
                String minPassAverageStr = etMinPassAverage.getText().toString();
                String allowedQuestionType = etAllowedQuestionType.getText().toString();
                String examName = etExamName.getText().toString().trim();
                String totalMarksStr = etTotalMarks.getText().toString();
                if (numberOfQuestionsStr.isEmpty() || minPassAverageStr.isEmpty() || allowedQuestionType.isEmpty()||examName.isEmpty()||totalMarksStr.isEmpty()) {
                    Toast.makeText(AddExamActivity.this, "الرجاء ملء جميع الحقول", Toast.LENGTH_SHORT).show();
                    return;
                }

                int numberOfQuestions;
                double minPassAverage;

                try {
                    numberOfQuestions = Integer.parseInt(numberOfQuestionsStr);
                    minPassAverage = Double.parseDouble(minPassAverageStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(AddExamActivity.this, "الرجاء إدخال قيم صالحة", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (numberOfQuestions <= 0) {
                    Toast.makeText(AddExamActivity.this, "عدد الأسئلة يجب أن يكون أكبر من صفر", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<Question> questions = dbHelper.getRandomQuestions(numberOfQuestions);
                   int totalMarksStr1=Integer.parseInt(totalMarksStr);
                Exam exam = new Exam(examName,numberOfQuestions, minPassAverage,totalMarksStr1 ,allowedQuestionType, questions);

                boolean success = dbHelper.addExam(exam);

                if (success) {
                    Toast.makeText(AddExamActivity.this, "تم إنشاء الاختبار بنجاح", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddExamActivity.this, "فشل إنشاء الاختبار", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

