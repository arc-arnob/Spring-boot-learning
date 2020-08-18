package com.serviceapi.serviceapi.service;

import java.util.List;

import com.serviceapi.serviceapi.model.Employee;

// Performing Loose Coupling
public interface EmployeeService {
    
    public List<Employee> getEmployee();
    
    public Employee getEmployeeById(long empId);

    public Employee addEmployee(Employee employee);

}