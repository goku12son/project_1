package com.example.project_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_STUDENTS = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_STUDENT_DateOfBirth = "DateOfBirth";
    private static final String COLUMN_STUDENT_universityid = "universityid";
    private static final String COLUMN_STUDENT_Gender = "Gender";
    private static final String TABLE_TEACHER = "Teacher";
    private static final String COLUMN_TEACHER_NAME = "Teachername";
    private static final String COLUMN_TEACHER_USERNAME = "Teacherusername";
    private static final String COLUMN_TEACHER_ID = "Teacher_id";
    private static final String COLUMN_TEACHER_DateOfBirth = "DateOfBirth";
    private static final String COLUMN_TEACHER_Gender = "Gender";
    private static final String COLUMN_TEACHER_Salary = "Salary";
    private static final String COLUMN_TEACHER_Specialty = "Specialty";


    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_STUDENTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_STUDENT_ID + " TEXT, " + COLUMN_USERNAME + " TEXT, " +
                COLUMN_STUDENT_DateOfBirth + " TEXT, " + COLUMN_STUDENT_universityid +
                " INTEGER not null, " + COLUMN_STUDENT_Gender + " TEXT)";
        db.execSQL(createTableQuery);
        String createTableQuery2 = "CREATE TABLE " + TABLE_TEACHER + "(" +
                COLUMN_TEACHER_NAME + " TEXT, " +
                COLUMN_TEACHER_USERNAME + " TEXT, " + COLUMN_TEACHER_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_TEACHER_DateOfBirth + " TEXT, " + COLUMN_TEACHER_Gender + " TEXT, " +
                COLUMN_TEACHER_Salary + " INTEGER, " + COLUMN_TEACHER_Specialty + " TEXT )";
        db.execSQL(createTableQuery2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_STUDENTS;
        db.execSQL(dropTableQuery);
        String dropTableQuery2 = "DROP TABLE IF EXISTS " + TABLE_TEACHER;
        db.execSQL(dropTableQuery2);
        onCreate(db);
    }

    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_STUDENT_ID, student.getId());
        values.put(COLUMN_USERNAME, student.getName2());
        values.put(COLUMN_STUDENT_universityid, student.getUniversityid());
        values.put(COLUMN_STUDENT_DateOfBirth, student.getDate());
        values.put(COLUMN_STUDENT_Gender, student.getGender());
        long row = db.insert(TABLE_STUDENTS, null, values);
        return row > 0;
    }

    public ArrayList<Student> getAllStudent() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Student> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_STUDENTS + " ORDER BY " + COLUMN_STUDENT_universityid + " DESC";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String student_ID = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STUDENT_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME));
                String dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STUDENT_DateOfBirth));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STUDENT_Gender));
                String universityid = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STUDENT_universityid));
                Student student = new Student(name, student_ID, username, dateOfBirth, universityid, gender);
                data.add(student);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return data;
    }

    public boolean addTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEACHER_USERNAME, teacher.getUsername());
        values.put(COLUMN_TEACHER_NAME, teacher.getName());
        values.put(COLUMN_TEACHER_ID, teacher.getId_pass());
        values.put(COLUMN_TEACHER_DateOfBirth, teacher.getDate());
        values.put(COLUMN_TEACHER_Gender, teacher.getGender());
        values.put(COLUMN_TEACHER_Salary, teacher.getSalary());
        values.put(COLUMN_TEACHER_Specialty, teacher.getSpecialty());
        long row = db.insert(TABLE_TEACHER, null, values);
        return row > 0;
    }

    public ArrayList<Teacher> getAllTeacher() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Teacher> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_TEACHER;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String teacher_ID = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_NAME));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_USERNAME));
                String dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_DateOfBirth));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_Gender));
                String specialty = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_Specialty));
                int salary = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TEACHER_Salary));
                Teacher teacher = new Teacher(name, username, teacher_ID, dateOfBirth, specialty, gender, salary);
                data.add(teacher);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return data;
    }

}
