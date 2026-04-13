package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee createEmployeeWithArgs(String name, String email, int age, String department, double salary) {
        Employee emp = Employee.builder()
                .name(name)
                .email(email)
                .age(age)
                .department(department)
                .salary(salary)
                .build();

        return repository.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}