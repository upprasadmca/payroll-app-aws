package com.csoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csoft.app.mapper.EmployeeMapper;
import com.csoft.app.model.Employee;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getAllEmployees() {
		return employeeMapper.findAll();
	}
	
	public boolean saveEmployee(Employee employee) {
		return employeeMapper.insert(employee) > 0 ? true : false;
	}

}
