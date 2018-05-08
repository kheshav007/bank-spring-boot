package com.accenture.aa.banking.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aa.banking.dao.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
