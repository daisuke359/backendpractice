package com.daisuke.backendpractice.model;

import java.util.Formatter;

public class Student {
    private int id;
    private String name;
    private String major;

    public Student() {

    }

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getMajor() {
        return this.major;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
