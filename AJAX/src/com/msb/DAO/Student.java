package com.msb.DAO;

import java.util.Date;

public class Student {
    private String name;
    private String gender;
    private int age;
    private Date date;

    public Student(){}

    public Student(String name, String gender, int age, Date date) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.date = date;
    }
}
