package com.accenture.aa.banking.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aa.banking.api.dtos.EmployeeDTO;
import com.accenture.aa.banking.services.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

	private final static String ROLE_CREATE_EMPLOYEE = "ROLE_CREATE_EMPLOYEE";
	private final EmployeesService employeesService;
	

	private final BCryptPasswordEncoder passwordEncoder;

	public EmployeesController(EmployeesService employeesService, BCryptPasswordEncoder passwordEncoder) {
		this.employeesService = employeesService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping(value = "")
	@Secured(ROLE_CREATE_EMPLOYEE)
	public HttpEntity<?> createEmployee(@RequestBody EmployeeDTO dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		employeesService.createUser(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "")
	@Secured(ROLE_CREATE_EMPLOYEE)
	public HttpEntity<?> createEmployee2(@RequestBody EmployeeDTO dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		employeesService.createUser(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
