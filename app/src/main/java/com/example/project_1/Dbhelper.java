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
    private static final int DATABASE_VERSION = 5;

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
   private static final String TABLE_QUESTIONS = "questions";
    private static final String COLUMN_QUESTIONS_ID = "id";
    private static final String COLUMN_QUESTION_TEXT = "question_text";
    private static final String COLUMN_MARKS_WEIGHT = "marks_weight";
    private static final String COLUMN_ANSWER = "answer";
    private static final String TABLE_EXAMS = "exams";
    private static final String COLUMN_EXAMS_ID = "id";
    private static final String COLUMN_NUMBER_OF_QUESTIONS = "number_of_questions";
    private static final String COLUMN_MIN_PASS_AVERAGE = "min_pass_average";
    private static final String COLUMN_ALLOWED_QUESTION_TYPE = "allowed_question_type";
    private static final String COLUMN_EXAM_NAME = "exam_name";
    private static final String COLUMN_TOTAL_MARKS = "total_marks";



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
        String createTableQuery3 = "CREATE TABLE " + TABLE_QUESTIONS + "(" +
                COLUMN_QUESTIONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION_TEXT + " TEXT, " +
                COLUMN_MARKS_WEIGHT + " REAL, " +
                COLUMN_ANSWER + " INTEGER)";
        db.execSQL(createTableQuery3);
        String CREATE_EXAMS_TABLE = "CREATE TABLE " + TABLE_EXAMS + "("
                + COLUMN_EXAMS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_EXAM_NAME + " TEXT,"
                + COLUMN_NUMBER_OF_QUESTIONS + " INTEGER,"
                + COLUMN_MIN_PASS_AVERAGE + " REAL,"
                + COLUMN_TOTAL_MARKS + " INTEGER,"
                + COLUMN_ALLOWED_QUESTION_TYPE + " TEXT"
                + ")";
        db.execSQL(CREATE_EXAMS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAMS);
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

    public boolean checkTeacherLogin(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_TEACHER + " WHERE " + COLUMN_TEACHER_USERNAME + " = ? AND " +
                COLUMN_TEACHER_ID + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }
    public boolean addQuestion(String questionText, double marksWeight, boolean answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, questionText);
        values.put(COLUMN_MARKS_WEIGHT, marksWeight);
        values.put(COLUMN_ANSWER, answer ? 1 : 0);
        long rowId = db.insert(TABLE_QUESTIONS, null, values);
        db.close();
        return rowId >0;
    }
    public ArrayList<Question> getAllQuestion() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Question> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_QUESTIONS ;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int qUESTIONS_ID = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUESTIONS_ID));
                String tEXT = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
                double mARKS = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_MARKS_WEIGHT));
                int answerValue = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
                boolean answer = (answerValue== 1);
                Question question=new Question(qUESTIONS_ID,tEXT,mARKS, answer);
                data.add(question);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return data;
    }
    public boolean updateQuestion(int id, String questionText, double marksWeight, boolean answer) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, questionText);
        values.put(COLUMN_MARKS_WEIGHT, marksWeight);
        values.put(COLUMN_ANSWER, answer ? 1 : 0);
        String selection = COLUMN_QUESTIONS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        int rowsAffected = db.update(TABLE_QUESTIONS, values, selection, selectionArgs);
        return rowsAffected > 0;
    }
    public boolean addExam(Exam exam) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXAM_NAME, exam.getName());
        values.put(COLUMN_NUMBER_OF_QUESTIONS, exam.getNumberOfQuestions());
        values.put(COLUMN_MIN_PASS_AVERAGE, exam.getMinPassAverage());
        values.put(COLUMN_TOTAL_MARKS, exam.getTotalMarks());
        values.put(COLUMN_ALLOWED_QUESTION_TYPE, exam.getAllowedQuestionType());
        long result = db.insert(TABLE_EXAMS, null, values);
        db.close();
        return result > 0;
    }
    public ArrayList<Question> getRandomQuestions(int numberOfQuestions) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_QUESTIONS + " ORDER BY RANDOM() LIMIT " + numberOfQuestions;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int questionId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUESTIONS_ID));
                String questionText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
                double marksWeight = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_MARKS_WEIGHT));
                int answerValue = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
                boolean answer = (answerValue == 1);
                Question question = new Question(questionId, questionText, marksWeight, answer);
                questions.add(question);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return questions;
    }

    public ArrayList<Exam> getExams() {
        ArrayList<Exam> examList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_EXAMS;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int examId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EXAMS_ID));
                String examName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EXAM_NAME));
                int numberOfQuestions = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMBER_OF_QUESTIONS));
                double minPassAverage = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_MIN_PASS_AVERAGE));
                int totalMarks = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TOTAL_MARKS));
                String allowedQuestionType = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALLOWED_QUESTION_TYPE));
                ArrayList<Question> questions = getRandomQuestions(examId);
                Exam exam = new Exam(examName, numberOfQuestions, minPassAverage, totalMarks, allowedQuestionType, questions);
                examList.add(exam);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return examList;
    }

}
