package com.example.javaspring.controller;

import com.example.javaspring.entity.Employee;
import com.example.javaspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private static ArrayList<Employee> list = new ArrayList<>();

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAllEmployee(@RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "10") int limit) {
        return employeeService.findAllEmployee();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable String id, @RequestBody Employee updateEmployee) {
        Employee employee = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(id)) {
                employee = list.get(i);
                break;
            }
        }
        employee.setName(updateEmployee.getName());
        employee.setWage(updateEmployee.getWage());
        return employee;
    }
}
