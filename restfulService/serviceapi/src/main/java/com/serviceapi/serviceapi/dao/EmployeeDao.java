package com.serviceapi.serviceapi.dao;

import com.serviceapi.serviceapi.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
