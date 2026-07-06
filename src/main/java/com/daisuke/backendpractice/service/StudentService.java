package com.daisuke.backendpractice.service;

import com.daisuke.backendpractice.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Daisuke", "Computer Science"));
        students.add(new Student(2, "Alice", "AI"));
        students.add(new Student(3, "Bob", "Software"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
        for(Student student : students) {
            if(student.getId()==id) {
                return student;
            }
        }
        return null;
    }


    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }


    public Student deleteStudent(int id) {
        for(int i=0;i<students.size();i++) {
            if(students.get(i).getId()==id) {
                return students.remove(i);
            }
        }
        return null;
    }


    public Student updateStudent(int id, Student student) {
        for(Student s : students) {
            if(s.getId()==id) {
                s.setName(student.getName());
                s.setMajor(student.getMajor());
                return s;
            }
        }
        return null;
    }
}
