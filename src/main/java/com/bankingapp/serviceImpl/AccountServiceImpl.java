package com.bankingapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.AccountRepo;
import com.bankingapp.model.Account;
import com.bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public Account createAccount(Account account) {
		accountRepo.save(account);
		return account;		
	}

	@Override
	public Account getAccount(int id) {
		Account account= accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account does not Exist"));
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> allAccounts= accountRepo.findAll();
		return allAccounts;
	}

	@Override
	public Account deposit(int id, double amount) {
		
	Account account = 
			accountRepo.findById(id)
			.orElseThrow(()-> new RuntimeException("Account does not exist"));
	
	double totel= account.getAmount()+amount;
	account.setAmount(totel);
	Account updatedAccount=accountRepo.save(account);
	
		return updatedAccount;
	}

	@Override
	public Account withdraw(int id, double amount) {
		
		Account account = 
				accountRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Account does not exist"));
	

        if(account.getAmount()<amount) {
        	throw new RuntimeException("Insufficent amount");
        }
        
        double totel= account.getAmount()-amount;
    	account.setAmount(totel);
    	Account updatedAccount=accountRepo.save(account);
        
		return updatedAccount;
	}

	@Override
	public void deleteAccount(int id) {
		accountRepo.deleteById(id);
		
	}
	
	
}
