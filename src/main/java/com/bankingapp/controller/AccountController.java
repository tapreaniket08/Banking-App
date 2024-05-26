package com.bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.dao.AccountRepo;
import com.bankingapp.model.Account;
import com.bankingapp.serviceImpl.AccountServiceImpl;

@RestController
@RequestMapping("api/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountServiceImpl;

	// http://localhost:8181/api/account/add-account
	@PostMapping("/add-account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return new ResponseEntity<>(accountServiceImpl.createAccount(account), HttpStatus.CREATED);
	}

	// http://localhost:8181/api/account/get-account/1
	@GetMapping("/get-account/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable int id) {
		return new ResponseEntity<>(accountServiceImpl.getAccount(id), HttpStatus.OK);
	}

	// http://localhost:8181/api/account/get-all-account
	@GetMapping("/get-all-account")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return new ResponseEntity<>(accountServiceImpl.getAllAccounts(), HttpStatus.OK);
	}

	// http://localhost:8181/api/account/deposit/{id}
	@PutMapping("/deposit/{id}")
	public ResponseEntity<Account> depositAmount(@PathVariable int id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		Account updateAccount = accountServiceImpl.deposit(id, amount);
		return new ResponseEntity<>(updateAccount, HttpStatus.OK);
	}

	// http://localhost:8181/api/account/withdraw/{id}
	@PutMapping("/withdrow/{id}")
	public ResponseEntity<Account> withdraw(@PathVariable int id, @RequestBody Map<String, Double> request) {
		double amount = request.get("amount");
		Account updateAccount = accountServiceImpl.withdraw(id, amount);
		return ResponseEntity.ok(updateAccount);
	}

	// http://localhost:8181/api/account/delete-account/{id}
	@DeleteMapping("/delete-account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
		accountServiceImpl.deleteAccount(id);
		return ResponseEntity.ok("Account delete sucessfully");
	}
}
