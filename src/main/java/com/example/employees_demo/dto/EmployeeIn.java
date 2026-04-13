package com.example.employees_demo.dto;


import com.example.employees_demo.model.Employee;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class EmployeeIn  implements Serializable {
    @NotBlank
    @Length(min = 5, max = 30)
    private String fullName;

    @Min(0)
    @Max(120)
    private Integer age;

    @Min(1)
    @Max(60)
    private Integer SeniorityInTheCompany;

    @NotBlank
    private Integer salary;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSeniorityInTheCompany() {
        return SeniorityInTheCompany;
    }

    public void setSeniorityInTheCompany(Integer seniorityInTheCompany) {
        SeniorityInTheCompany = seniorityInTheCompany;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee toEmployee(EmployeeIn employeeIn) {
        return new Employee(
                employeeIn.getFullName(),
                employeeIn.getAge(),
                employeeIn.getSeniorityInTheCompany(),
                employeeIn.getSalary()
        );
    }

    public void updateEmployee(Employee  employee) {
        employee.setFullName(fullName);
        employee.setAge(age);
        employee.setSeniorityInTheCompany(SeniorityInTheCompany);
        employee.setSalary(salary);
    }
}
