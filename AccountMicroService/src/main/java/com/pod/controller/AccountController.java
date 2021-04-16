package com.pod.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pod.models.Account;
import com.pod.models.AccountCreationStatus;
import com.pod.models.Statement;
import com.pod.models.TransactionStatus;
import com.pod.repository.AccountRepo;
import com.pod.service.AccountServiceInterface;

@RestController
public class AccountController {

	@Autowired
	AccountServiceInterface accountService;
	
	@Autowired
	AccountRepo accountRepo;

	@PostMapping("/createAccount")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token, @RequestBody int custId) {
		return accountService.createAccount(token,custId);
	}

	@PostMapping("/createCurrentAccount")
	public AccountCreationStatus createCurrentAccount(@RequestHeader("Authorization") String token, @RequestBody int custId) {
		return accountService.createCurrentAccount(token,custId);
	}
	
	@PostMapping("/createSavingsAccount")
	public AccountCreationStatus createSavingsAccount(@RequestHeader("Authorization") String token, @RequestBody int custId) {
		return accountService.createSavingsAccount(token,custId);
	}
	
	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccounts(@RequestHeader("Authorization") String token) {
		return accountService.getAllAccounts();
	}

	@PostMapping("/getCustomerAccounts")
	public List<Account> getCustomerAccounts(@RequestHeader("Authorization") String token,@RequestBody int custId) {
		System.out.println(custId);
		return accountService.getCustomerAccounts(custId);
	}

	@GetMapping("/getAccount/{AccountId}")
	public Account getAccount(@RequestHeader("Authorization") String token, @PathVariable long AccountId) {
		return accountService.getAccount(AccountId);
	}

	@GetMapping("/getAccountStatement/{accId}/{from}/{to}")
	public Statement getAccountStatement(@RequestHeader("Authorization") String token,
			@PathVariable("accId") long accId, @PathVariable("from") LocalDate from, @PathVariable("to") LocalDate to) {
		return accountService.getAccountStatement(accId, from, to);
	}

	@PostMapping("/deposit/{AccountId}/{amount}")
	public TransactionStatus deposit(@RequestHeader("Authorization") String token, @PathVariable long AccountId,
			@PathVariable double amount) {
		return accountService.deposit(AccountId, amount);
	}

	@PostMapping("/withdraw/{AccountId}/{amount}")
	public TransactionStatus withdraw(@RequestHeader("Authorization") String token, @PathVariable long AccountId,
			@PathVariable double amount) {
		return accountService.withdraw(AccountId, amount);
	}

	@PostMapping("/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
	public TransactionStatus transfer(@RequestHeader("Authorization") String token, @PathVariable long sourceAccountId,
			@PathVariable long targetAccountId, @PathVariable double amount) {
		return accountService.transfer(sourceAccountId, targetAccountId, amount);
	}

	@PostMapping("/hello")
	public String sayHi(@RequestHeader("joshPatti") String uname) {
		return uname;
	}
	
	@PostMapping("/saveAccount")
	public void saveAcc(@RequestHeader("Authorization") String token,@RequestBody Account account) {
		accountRepo.save(account);
	}
	@DeleteMapping("/delete")
	public boolean delete(@RequestHeader("Authorization") String token, @RequestBody int custId) {
		return accountService.deleteAccount(custId);
	}
}
