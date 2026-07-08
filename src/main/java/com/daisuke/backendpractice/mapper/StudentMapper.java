package com.daisuke.backendpractice.mapper;

import com.daisuke.backendpractice.dto.CreateStudentRequest;
import com.daisuke.backendpractice.dto.StudentResponse;
import com.daisuke.backendpractice.model.Student;

public class StudentMapper {
    public static Student toStudent(CreateStudentRequest request) {
        return new Student(0, request.getName(), request.getMajor());
    }

    public static StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getMajor()
        );

    }
}
