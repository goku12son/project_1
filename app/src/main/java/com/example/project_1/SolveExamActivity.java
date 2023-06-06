package com.example.project_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SolveExamActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button nextButton;
    private TextView resultTextView;
    private List<String> options;
    String result;
    private ArrayList<Question> questionList;
    private int currentQuestionIndex;
    private ArrayList<String> studentAnswers = new ArrayList<>();
    ArrayList<ExamResultDetails> examResultDetailsList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_exam);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        resultTextView = findViewById(R.id.resultTextView);

        Exam exam = (Exam) getIntent().getSerializableExtra("exam");
        questionList = exam.getQuestions();

        currentQuestionIndex = 0;
        displayQuestion(currentQuestionIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion(int questionIndex) {
        if (questionIndex < questionList.size()) {
            Question question = questionList.get(questionIndex);
            questionTextView.setText(question.getQuestionText());

            answerRadioGroup.removeAllViews();
            nextButton.setEnabled(false);

            options = question.getAnswer().getOptions();
            createOptions(options);

            answerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    nextButton.setEnabled(true);
                }
            });
        } else {
            calculateResult();
        }
    }

    private void calculateResult() {
        int correctAnswers = 0;
        examResultDetailsList = new ArrayList<>();

        for (Question question : questionList) {
            String studentAnswer = question.getAnswer().getUserAnswer();
            Answer correctAnswer = question.getAnswer();
            int marks = correctAnswer.getOptions().contains(studentAnswer) ? 1 : 0;

            if (marks > 0) {
                correctAnswers++;
            }

            examResultDetailsList.add(new ExamResultDetails(question, studentAnswer, correctAnswer, marks));
        }

        int totalQuestions = questionList.size();
        double percentage = (double) correctAnswers / totalQuestions * 100;
         result = "Result: " + correctAnswers + " out of " + totalQuestions + " correct (" + percentage + "%)";
        resultTextView.setText(result);
        resultTextView.setVisibility(View.VISIBLE);
        nextButton.setEnabled(false);
        nextButton.setVisibility(View.GONE);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("percentage", (float) percentage);
        editor.apply();

        Intent intent = new Intent(SolveExamActivity.this, ExamResultDetailsActivity.class);
        intent.putExtra("examResultDetailsList", examResultDetailsList);
        startActivity(intent);
    }



    public void checkAnswer() {
        Question question = questionList.get(currentQuestionIndex);
        int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            System.out.println("Selected Answer: " + selectedAnswer);
            question.getAnswer().setUserAnswer(selectedAnswer);

            studentAnswers.add(selectedAnswer);

            currentQuestionIndex++;
            if (currentQuestionIndex < questionList.size()) {
                displayQuestion(currentQuestionIndex);
            } else {
                calculateResult();
            }
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void createOptions(List<String> options) {
        answerRadioGroup.removeAllViews();

        for (String option : options) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioButton.setTag(option);
            answerRadioGroup.addView(radioButton);
        }

        RadioButton wrongRadioButton = new RadioButton(this);
        wrongRadioButton.setText("false");
        wrongRadioButton.setTag("false");
        answerRadioGroup.addView(wrongRadioButton);
    }
}
