package com.bankingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapp.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
