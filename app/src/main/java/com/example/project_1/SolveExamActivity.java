package com.example.project_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SolveExamActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button nextButton;
    private TextView resultTextView;

    private ArrayList<Question> questionList;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_exam);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        resultTextView = findViewById(R.id.resultTextView);

        Exam exam = (Exam) getIntent().getExtras().getSerializable("exam");
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

            answerRadioGroup.clearCheck();
            answerRadioGroup.setOnCheckedChangeListener(null);
            nextButton.setEnabled(false);

            ArrayList<String> options = question.getAnswer().getOptions();
            for (String option : options) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(option);
                answerRadioGroup.addView(radioButton);
            }

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
        for (Question question : questionList) {
            Answer answer = question.getAnswer();
            String selectedAnswer = answer.getUserAnswer();
            String correctAnswer = answer.getOptions().get(0); // Assuming the correct answer is always the first option

            if (selectedAnswer.equals(correctAnswer)) {
                correctAnswers++;
            }
        }

        int totalQuestions = questionList.size();
        double percentage = (double) correctAnswers / totalQuestions * 100;
        String result = "Result: " + correctAnswers + " out of " + totalQuestions + " correct (" + percentage + "%)";
        resultTextView.setText(result);
        resultTextView.setVisibility(View.VISIBLE);
        nextButton.setEnabled(false);
    }

    private void checkAnswer() {
        Question question = questionList.get(currentQuestionIndex);
        int selectedAnswerId = answerRadioGroup.getCheckedRadioButtonId();

        if (selectedAnswerId != -1) {
            RadioButton selectedAnswerRadioButton = findViewById(selectedAnswerId);
            String selectedAnswer = selectedAnswerRadioButton.getText().toString();
            Answer answer = question.getAnswer();
            String correctAnswer = answer.getOptions().get(0); // Assuming the correct answer is always the first option

            if (selectedAnswer.equals(correctAnswer)) {
                Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect answer.", Toast.LENGTH_SHORT).show();
            }

            currentQuestionIndex++;
            displayQuestion(currentQuestionIndex);
        } else {
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
    }
}
