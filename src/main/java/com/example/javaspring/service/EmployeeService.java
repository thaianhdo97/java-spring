package com.example.javaspring.service;

import com.example.javaspring.entity.Employee;
import com.example.javaspring.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

public class EmployeeService {
    @Autowired
    private EmployeeJpaRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
}
