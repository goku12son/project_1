package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {
    private ArrayList<Exam> examList;
    Context context;
     onClickIteum listener;

    public ExamAdapter(ArrayList<Exam> examList, Context context, onClickIteum listener) {
        this.examList = examList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exam, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        holder.minPassAverageTextView.setText("الحد الأدنى للنجاح: " + String.valueOf(examList.get(holder.getAdapterPosition()).getMinPassAverage()));
        holder.examNameTextView.setText("اسم الاختبار: " + examList.get(holder.getAdapterPosition()).getName());
        holder.numberOfQuestionsTextView.setText("عدد الأسئلة: " + String.valueOf(examList.get(holder.getAdapterPosition()).getNumberOfQuestions()));
        holder.totalMarksTextView.setText("إجمالي العلامات: " + String.valueOf(examList.get(holder.getAdapterPosition()).getTotalMarks()));
    holder.contener.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.onClick(examList.get(holder.getAdapterPosition()));

        }
    });

    }

    @Override
    public int getItemCount() {
        return examList.size();
    }



    public static class ExamViewHolder extends RecyclerView.ViewHolder {
        TextView examNameTextView;
        TextView numberOfQuestionsTextView;
        TextView minPassAverageTextView;
        TextView totalMarksTextView;
    LinearLayout contener;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            examNameTextView = itemView.findViewById(R.id.examNameTextView);
            numberOfQuestionsTextView = itemView.findViewById(R.id.numberOfQuestionsTextView);
            minPassAverageTextView = itemView.findViewById(R.id.minPassAverageTextView);
            totalMarksTextView = itemView.findViewById(R.id.totalMarksTextView);
            contener=itemView.findViewById(R.id.contener2);
        }

    }
    public interface onClickIteum{
        void onClick(Exam exam);
    }
}
