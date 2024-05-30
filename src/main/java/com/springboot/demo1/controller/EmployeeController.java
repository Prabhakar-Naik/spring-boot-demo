package com.springboot.demo1.controller;

import com.springboot.demo1.dao.EmployeeDAO;
import com.springboot.demo1.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }



    @GetMapping("/hello")
    public ResponseEntity<?> getMessage() {
        return ResponseEntity.ok("Hello Employee Welcome to Java World!");
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            employee.setEmpId(UUID.randomUUID().toString());
            Employee employee1 = this.employeeDAO.save(employee);
            return ResponseEntity.ok("Employee Added:\n" + employee1);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("employee not added." + e.getMessage());
        }
    }

    @GetMapping("/getEmployeeById/{empId}")
    public ResponseEntity<?> returnEmployee(@PathVariable String empId) {
        if (this.employeeDAO.findById(empId).isPresent()) {
            try {
                return ResponseEntity.ok(this.employeeDAO.findById(empId).get());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Employee Not Found." + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Employee Not Found");
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> getAllEmployees() {
        if (!this.employeeDAO.findAll().isEmpty()) {
            try {
                return ResponseEntity.ok(this.employeeDAO.findAll());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Employees Not Found." + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Collection is Empty");
    }

    @PutMapping("/updateEmployeeById/{empId}")
    public ResponseEntity<?> updateEmployee(@PathVariable String empId, @RequestBody Employee employee) {
        Optional<Employee> employeeExist = this.employeeDAO.findById(empId);
        if (employeeExist.isPresent()) {
            try {
                employeeExist.get().setEmpName(employee.getEmpName());
                employeeExist.get().setAddress(employee.getAddress());
                employeeExist.get().setSalary(employee.getSalary());
                this.employeeDAO.save(employeeExist.get());
                return ResponseEntity.ok("Employee Updated:\n" + employeeExist);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Employee Not Updated." + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Employee Not Found");
    }


    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String empId) {
        if (this.employeeDAO.findById(empId).isPresent()) {
            try {
                this.employeeDAO.deleteById(empId);
                return ResponseEntity.ok("Deleted");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Employee Not Deleted." + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().body("Employee Not Found");
    }


}
