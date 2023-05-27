package com.example.project_1;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String name2;
    private  String id;
    private String date;
    private String universityid;
    private String gender;
    public Student(){}
    public Student(String name, String id,String name2 ,String date, String university, String gender) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.universityid = university;
        this.gender = gender;
        this.name2=name2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getUniversityid() {
        return universityid;
    }

    public void setUniversityid(String universityid) {
        this.universityid = universityid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", universityid='" + universityid + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
