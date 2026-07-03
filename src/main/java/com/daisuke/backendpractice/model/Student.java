package com.daisuke.backendpractice.model;

import java.util.Formatter;

public class Student {
    private int id;
    private String name;
    private String major;

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
}
