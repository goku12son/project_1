package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ExamResultDetailsHolder> {
    private Context context;
    private ArrayList<ExamResultDetails> examResultDetails;

    public ResultAdapter(Context context, ArrayList<ExamResultDetails> examResultDetails) {
        this.context = context;
        this.examResultDetails = examResultDetails;
    }

    @NonNull
    @Override
    public ExamResultDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itum_view_result, parent, false);
        return new ExamResultDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamResultDetailsHolder holder, int position) {
        ExamResultDetails resultDetails = examResultDetails.get(position);
        holder.questionTextView.setText("Question: " + resultDetails.getQuestion().getQuestionText());
        holder.correctAnswerTextView.setText("Correct Answer: " + resultDetails.getCorrectAnswer().getUserAnswer());
        holder.marksTextView.setText("Question Marks: " + resultDetails.getMarks());
        holder.studentAnswerTextView.setText("Your Answer: " + resultDetails.getStudentAnswer());
    }

    @Override
    public int getItemCount() {
        return examResultDetails.size();
    }

    public static class ExamResultDetailsHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, studentAnswerTextView, correctAnswerTextView, marksTextView;

        public ExamResultDetailsHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            studentAnswerTextView = itemView.findViewById(R.id.studentAnswerTextView);
            correctAnswerTextView = itemView.findViewById(R.id.correctAnswerTextView);
            marksTextView = itemView.findViewById(R.id.marksTextView);
        }
    }
}
