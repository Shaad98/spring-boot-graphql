package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // 🔹 Query: Get all employees
    @QueryMapping
    public List<Employee> employees() {
        return service.getAllEmployees();
    }

    // 🔹 Query: Get employee by ID
    @QueryMapping
    public Employee employeeById(@Argument UUID id) {
        return service.getEmployeeById(id);
    }

    // 🔹 Mutation using FULL INPUT
    @MutationMapping
    public Employee createEmployee(@Argument EmployeeInput input) {
        Employee emp = Employee.builder()
                .name(input.getName())
                .email(input.getEmail())
                .age(input.getAge())
                .department(input.getDepartment())
                .salary(input.getSalary())
                .build();

        return service.createEmployee(emp);
    }

    // 🔹 Mutation using SEPARATE ARGS
    @MutationMapping
    public Employee createEmployeeArgs(
            @Argument String name,
            @Argument String email,
            @Argument int age,
            @Argument String department,
            @Argument double salary
    ) {
        return service.createEmployeeWithArgs(name, email, age, department, salary);
    }
}