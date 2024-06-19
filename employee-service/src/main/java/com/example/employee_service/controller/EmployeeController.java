package com.example.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.Response.EmployeeResponse;
import com.example.employee_service.Service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getById(@PathVariable("id") int id)
	{
		
		EmployeeResponse employeeR= employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeR);
	}

}
