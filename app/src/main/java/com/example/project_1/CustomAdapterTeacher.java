package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterTeacher extends BaseAdapter {

    private Context context;
    private ArrayList<Teacher> teacherList;

    public CustomAdapterTeacher(Context context, ArrayList<Teacher> teacherList) {
        this.context = context;
        this.teacherList = teacherList;
    }

    @Override
    public int getCount() {
        return teacherList.size();
    }

    @Override
    public Object getItem(int position) {
        return teacherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.add_iteum_teacher, parent, false);
        }
        Teacher teacher = teacherList.get(position);
        TextView textViewName = view.findViewById(R.id.tv_name);
        TextView textViewName2 = view.findViewById(R.id.tv_name2);
        TextView textViewId = view.findViewById(R.id.tv_id);
        TextView textViewDateOfBirth = view.findViewById(R.id.tv_date);
        TextView textViewSpecialty = view.findViewById(R.id.tv_Specialty);
        TextView textViewSalary = view.findViewById(R.id.tv_Salary);
        TextView textViewGender = view.findViewById(R.id.tv_gender);

        textViewName.setText("username: " +teacher.getUsername());
        textViewId.setText("password: " + teacher.getId_pass());
        textViewName2.setText("Name:"+teacher.getName());
        textViewDateOfBirth.setText("Date of Birth: " + teacher.getDate());
        textViewGender.setText("Gender: " + teacher.getGender());
        textViewSpecialty.setText("Specialty:"+teacher.getSpecialty());
        textViewSalary.setText("Salary:"+teacher.getSalary());






        return view;
    }
}
