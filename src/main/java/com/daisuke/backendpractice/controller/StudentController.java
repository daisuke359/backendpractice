package com.daisuke.backendpractice.controller;

import com.daisuke.backendpractice.dto.CreateStudentRequest;
import com.daisuke.backendpractice.dto.StudentResponse;
import com.daisuke.backendpractice.mapper.StudentMapper;
import com.daisuke.backendpractice.model.Student;
import com.daisuke.backendpractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponse> getStudents() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for(Student student : studentService.getStudents()) {
            studentResponses.add(StudentMapper.toStudentResponse(student));
        }
        return studentResponses;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(StudentMapper.toStudentResponse(studentService.getStudent(id)));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student student = StudentMapper.toStudent(request);
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(StudentMapper.toStudentResponse(savedStudent));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok(StudentMapper.toStudentResponse(studentService.deleteStudent(id)));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable int id, @Valid @RequestBody CreateStudentRequest request) {
        Student student = StudentMapper.toStudent(request);
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(StudentMapper.toStudentResponse(updatedStudent));
    }

}
