package com.example.demo.controller;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInput {
    private String name;
    private String email;
    private int age;
    private String department;
    private double salary;
}