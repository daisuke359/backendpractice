package com.daisuke.backendpractice.controller;

import com.daisuke.backendpractice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private ArrayList<Student> students = new ArrayList<>();

    public HelloController() {
        students.add(new Student(1, "Daisuke", "Computer Science"));
        students.add(new Student(2, "Alice", "AI"));
        students.add(new Student(3, "Bob", "Software"));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        for(int i=0;i<students.size();i++) {
            if(students.get(i).getId()==id) {
                return students.get(i);
            }
        }
        return null;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }



}
