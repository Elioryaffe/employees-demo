package com.example.employees_demo.repo;

import com.example.employees_demo.model.Employee;
import com.example.employees_demo.repo.EmployeeRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
