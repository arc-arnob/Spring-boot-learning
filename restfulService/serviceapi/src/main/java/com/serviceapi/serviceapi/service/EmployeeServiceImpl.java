package com.serviceapi.serviceapi.service;

import java.util.List;

import com.serviceapi.serviceapi.dao.EmployeeDao;
import com.serviceapi.serviceapi.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeDao employeedao;

	@Override
	public List<Employee> getEmployee() {
		return employeedao.findAll();
		
	}

	@Override
	public Employee getEmployeeById(long empId) {
		
		return employeedao.findById(empId).orElse(null);
	}

    @Override
    public Employee addEmployee(Employee employee) {
        employeedao.save(employee);
        return employee;
    }
    
    
}