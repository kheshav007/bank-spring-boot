package com.accenture.aa.banking.api.dtos;

import java.util.HashSet;
import java.util.Set;

import com.accenture.aa.banking.dao.entities.Role;

public class EmployeeDTO {

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	public EmployeeDTO() {
	}

	public EmployeeDTO(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private Set<String> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getRoles() {
		return (roles != null)? roles: new HashSet<>();
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
