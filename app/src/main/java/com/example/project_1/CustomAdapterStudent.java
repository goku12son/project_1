package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapterStudent extends ArrayAdapter<Student> {

    private Context context;
    private ArrayList<Student> studentList;

    public CustomAdapterStudent(Context context, ArrayList<Student> studentList) {
        super(context, 0, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.add_iteum_student, parent, false);
        }

        Student student = studentList.get(position);

        TextView textViewName = view.findViewById(R.id.tv_name);
        TextView textViewName2 = view.findViewById(R.id.tv_name2);
        TextView textViewStudentId = view.findViewById(R.id.tv_id);
        TextView textViewDateOfBirth = view.findViewById(R.id.tv_date);
        TextView textViewGpa = view.findViewById(R.id.tv_avg);
        TextView textViewGender = view.findViewById(R.id.tv_gender);

        textViewName.setText("username: " + student.getName());
        textViewStudentId.setText("password: " + student.getId());
        textViewName2.setText("Name:"+student.getName2());
        textViewDateOfBirth.setText("Date of Birth: " + student.getDate());
        textViewGpa.setText("University_id: " + student.getUniversityid());
        textViewGender.setText("Gender: " + student.getGender());

        return view;
    }
}
