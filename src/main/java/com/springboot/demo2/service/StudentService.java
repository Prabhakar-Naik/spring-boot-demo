package com.springboot.demo2.service;

import com.springboot.demo2.entity.StudentData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<String> helloStudents();

    ResponseEntity<String> createStudent(StudentData studentData);

    ResponseEntity<StudentData> returnStudent(String id);

    ResponseEntity<List<StudentData>> getAllStudents();

    ResponseEntity<String> updateStudent(StudentData studentData);

    ResponseEntity<String> deleteStudent(String id);
}
