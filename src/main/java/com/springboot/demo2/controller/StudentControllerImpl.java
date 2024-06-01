package com.springboot.demo2.controller;

import com.springboot.demo2.entity.StudentData;
import com.springboot.demo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController{

    private final StudentService service;

    public StudentControllerImpl(StudentService studentService) {
        this.service = studentService;
    }

    @Override
    public ResponseEntity<String> helloStudents() {
        return this.service.helloStudents();
    }

    @Override
    public ResponseEntity<String> createStudent(StudentData studentData) {
        return this.service.createStudent(studentData);
    }

    @Override
    public ResponseEntity<StudentData> returnStudent(String id) {
        return this.service.returnStudent(id);
    }

    @Override
    public ResponseEntity<List<StudentData>> getAllStudents() {
        return this.service.getAllStudents();
    }

    @Override
    public ResponseEntity<String> updateStudent(StudentData studentData) {
        return this.service.updateStudent(studentData);
    }

    @Override
    public ResponseEntity<String> deleteStudent(String id) {
        return this.service.deleteStudent(id);
    }
}
