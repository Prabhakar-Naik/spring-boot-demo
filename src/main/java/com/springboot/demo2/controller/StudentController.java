package com.springboot.demo2.controller;

import com.springboot.demo2.entity.StudentData;
import com.springboot.demo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/students")
public interface StudentController {


    @GetMapping("/hello")
     ResponseEntity<String> helloStudents();


    @PostMapping("/createStudent")
    ResponseEntity<String> createStudent(@RequestBody StudentData studentData);

    @GetMapping("/returnStudent/{id}")
    ResponseEntity<StudentData> returnStudent(@PathVariable String id);

    @GetMapping("/getAllStudents")
    ResponseEntity<List<StudentData>> getAllStudents();

    @PutMapping("/updateStudent")
    ResponseEntity<String> updateStudent(@RequestBody StudentData studentData);


    @DeleteMapping("/deleteStudent/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable String id);

}
