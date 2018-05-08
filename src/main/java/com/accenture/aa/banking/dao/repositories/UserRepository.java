package com.accenture.aa.banking.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aa.banking.dao.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}
