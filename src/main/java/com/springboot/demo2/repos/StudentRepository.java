package com.springboot.demo2.repos;

import com.springboot.demo2.entity.StudentData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentData,String> {
}
