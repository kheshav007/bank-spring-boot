package com.accenture.aa.banking.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aa.banking.dao.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
