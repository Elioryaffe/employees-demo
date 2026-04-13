package com.example.employees_demo.service;

import com.example.employees_demo.model.Employee;
import com.example.employees_demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService  {
    @Autowired
    EmployeeRepository repository;

    public Iterable<Employee> all() {
        return repository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }
}