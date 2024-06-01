package com.springboot.demo2.service;

import com.springboot.demo2.entity.StudentData;
import com.springboot.demo2.repos.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<String> helloStudents() {
        return ResponseEntity.ok("Hello Students Welcome to Java World!");
    }

    @Override
    public ResponseEntity<String> createStudent(StudentData studentData) {
        return ResponseEntity.ok("Student Created");
    }

    @Override
    public ResponseEntity<StudentData> returnStudent(String id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<StudentData>> getAllStudents() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<String> updateStudent(StudentData studentData) {
        return ResponseEntity.ok("Student Record Updated.");
    }

    @Override
    public ResponseEntity<String> deleteStudent(String id) {
        return ResponseEntity.ok("Student Deleted.");
    }
}
