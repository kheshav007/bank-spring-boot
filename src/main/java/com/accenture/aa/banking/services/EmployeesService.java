package com.accenture.aa.banking.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.accenture.aa.banking.api.dtos.EmployeeDTO;
import com.accenture.aa.banking.dao.entities.Employee;
import com.accenture.aa.banking.dao.entities.User;
import com.accenture.aa.banking.dao.repositories.EmployeeRepository;
import com.accenture.aa.banking.dao.repositories.RoleRepository;

@Service
@Transactional
public class EmployeesService {

	private final EmployeeRepository employeeRepository;

	private final RoleRepository roleRepository;

	public EmployeesService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
		this.employeeRepository = employeeRepository;
		this.roleRepository = roleRepository;
	}

	public void createUser(EmployeeDTO dto) {

		Employee employee = new Employee();
		employee.setUsername(dto.getUsername());
		employee.setPassword(dto.getPassword());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());

		for (String role : dto.getRoles()) {
			employee.getRoles().add(roleRepository.findOne(role));
		}
		employeeRepository.save(employee);
	}
	
	public User getEmployee(String username) {
		return employeeRepository.findOne(username);
	}

}
