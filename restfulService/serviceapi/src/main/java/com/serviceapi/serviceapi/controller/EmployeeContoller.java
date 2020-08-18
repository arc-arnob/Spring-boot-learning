package com.serviceapi.serviceapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.serviceapi.serviceapi.model.Employee;
import com.serviceapi.serviceapi.service.EmployeeService;

@RestController
public class EmployeeContoller {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployee();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable String empId){
        return this.employeeService.getEmployeeById(Long.parseLong(empId));
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }
}