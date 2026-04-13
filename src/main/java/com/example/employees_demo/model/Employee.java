package com.example.employees_demo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="employee")

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public Employee() {
    }

    public Employee(String fullName, Integer age, Integer SeniorityInTheCompany, Integer salary) {
        this.fullName = fullName;
        this.age = age;
        this.SeniorityInTheCompany = SeniorityInTheCompany;
        this.salary = salary;
    }
}
