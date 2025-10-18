package com.csoft.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csoft.app.model.Employee;
import com.csoft.app.service.EmployeeServiceImpl;

@RestController
public class RestAPIController {
	
	@Autowired
	private EmployeeServiceImpl employImpl;
	
	@GetMapping(path = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employImpl.getAllEmployees(), HttpStatus.OK);
	}

	@PostMapping(path = "/employees/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		employImpl.saveEmployee(employee);
		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
	}
}
