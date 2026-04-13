package com.example.employees_demo.controller;


import com.example.employees_demo.dto.EmployeeIn;
import com.example.employees_demo.model.Employee;
import com.example.employees_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(employeeService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertEmployee(@RequestBody EmployeeIn employeeIn) {
        Employee employee = employeeIn.toEmployee(employeeIn);
        employee = employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeIn employee) {
        Optional<Employee> dbEmployee = employeeService.findById(id);
        employee.updateEmployee(dbEmployee.get());
        Employee updatedEmployee = employeeService.save(dbEmployee.get());
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> dbEmployee = employeeService.findById(id);
        employeeService.delete(dbEmployee.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}
