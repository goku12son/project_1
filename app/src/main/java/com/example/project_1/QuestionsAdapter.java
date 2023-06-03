package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {
    Context context;
     List<Question> questionList;
       onClickIteum listener;
    public QuestionsAdapter(Context context, List<Question> questionList,onClickIteum listener) {
        this.context = context;
        this.questionList = questionList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteum_viewquestion, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questionList.get(position);

        holder.questionTextView.setText(question.getQuestionText());
        holder.weightTextView.setText("Marks Weight: " + question.getMarksWeight());
        holder.contener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(questionList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView;
        TextView weightTextView;
        LinearLayout contener;

        QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            weightTextView = itemView.findViewById(R.id.weightTextView);
            contener=itemView.findViewById(R.id.contener);
        }

    }
   public interface onClickIteum{
        void onClick(Question question);
    }
}

