package com.accenture.aa.banking.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.aa.banking.dao.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
