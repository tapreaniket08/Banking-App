package com.bankingapp.service;

import java.util.List;

import com.bankingapp.model.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Account getAccount(int id);
	
	public List<Account> getAllAccounts();
	
	public Account deposit(int id ,double amount);
	
	public Account withdraw(int id ,double amount);

	public void deleteAccount(int id);
}
