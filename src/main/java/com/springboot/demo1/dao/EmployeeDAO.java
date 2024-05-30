package com.springboot.demo1.dao;


import com.springboot.demo1.pojo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends MongoRepository<Employee,String> {

}
