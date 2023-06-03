package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddquestionsActivity extends AppCompatActivity {
     EditText questionEditText;
     EditText weightEditText;
 RadioGroup answerRadioGroup;
 Button addQuestionButton;
     Dbhelper databaseHelper;
    Question question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addquestions);

        questionEditText = findViewById(R.id.questionEditText);
        weightEditText = findViewById(R.id.weightEditText);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        addQuestionButton = findViewById(R.id.addQuestionButton);
        databaseHelper = new Dbhelper(this);
        if (getIntent().getExtras()!=null){
         question= (Question)  getIntent().getExtras().getSerializable("question");
            if (question!=null){
                questionEditText.setText(question.getQuestionText());
                weightEditText.setText(String.valueOf((int) question.getMarksWeight()));
                addQuestionButton.setText("حفظ التغير");


            }
        }


        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionText = questionEditText.getText().toString();
                String marksWeightText = weightEditText.getText().toString();
                double marksWeight = Double.parseDouble(marksWeightText);
                boolean answer1 = getSelectedAnswer();

                if (question!=null){
                   boolean isSave= databaseHelper.updateQuestion(question.getId(),questionText,marksWeight,answer1);
                   if (isSave){
                       Toast.makeText(AddquestionsActivity.this, "تم التعديل", Toast.LENGTH_SHORT).show();
                      finish();

                   }else {
                       Toast.makeText(AddquestionsActivity.this, "فشل في تعدبل السؤال", Toast.LENGTH_SHORT).show();

                   }
                }else {  if (questionText.isEmpty() || marksWeightText.isEmpty()) {
                    Toast.makeText(AddquestionsActivity.this, "يرجى إدخال جميع الحقول", Toast.LENGTH_SHORT).show();
                    return;
                }

                    double marksWeight2 = Double.parseDouble(marksWeightText);
                    boolean answer = getSelectedAnswer();

                    boolean rowId = databaseHelper.addQuestion(questionText, marksWeight2, answer);

                    if (rowId) {
                        Toast.makeText(AddquestionsActivity.this, "تمت إضافة السؤال بنجاح", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddquestionsActivity.this, "فشل في إضافة السؤال", Toast.LENGTH_SHORT).show();
                    }
                }}



        });
    }

    private boolean getSelectedAnswer() {
        int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();
      RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedAnswer = selectedRadioButton.getText().toString();
        return selectedAnswer.equals("True");
    }


    }
