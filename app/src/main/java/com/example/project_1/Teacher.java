package com.example.project_1;

public class Teacher {
    private String name;
    private String username;
    private  String id_pass;
    private String date;
    private String Specialty;
    private String gender;
    private int Salary;

    public Teacher(String name, String username, String id_pass, String date, String specialty, String gender, int salary) {
        this.name = name;
        this.username = username;
        this.id_pass = id_pass;
        this.date = date;
       this. Specialty = specialty;
        this.gender = gender;
        this.Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId_pass() {
        return id_pass;
    }

    public void setId_pass(String id_pass) {
        this.id_pass = id_pass;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
