package com.daisuke.backendpractice.service;

import com.daisuke.backendpractice.exception.StudentNotFoundException;
import com.daisuke.backendpractice.model.Student;
import com.daisuke.backendpractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException(id);
        }
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student deleteStudent(int id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
        return student;
    }


    public Student updateStudent(int id, Student student) {
        Student studentToUpdate = getStudent(id);
        studentToUpdate.setName(student.getName());
        studentToUpdate.setMajor(student.getMajor());
        return studentRepository.save(studentToUpdate);
    }
}
