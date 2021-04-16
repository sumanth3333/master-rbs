package com.pod.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod.Feign.CustomerFeign;
import com.pod.models.Account;
import com.pod.models.AccountCreationStatus;
import com.pod.models.Statement;
import com.pod.models.TransactionStatus;
import com.pod.repository.AccountRepo;

@Service
public class AccountService implements AccountServiceInterface {

	@Autowired
	CustomerFeign customerFeign;
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public AccountCreationStatus createAccount(String token, int custId) {

		System.out.println(custId);
		if (customerFeign.getDetails(token, custId) != null) {
			Account savingsAcc = accountRepo.save(new Account(Account.AccSeq++, custId, 200, "SAVINGS", null));
			Account currentAcc = accountRepo.save(new Account(Account.AccSeq++, custId, 200, "CURRENT", null));
			return new AccountCreationStatus(savingsAcc.getAccountId(), "SAVINGS & CURRENT ACCOUNTS ARE CREATED");
		}
		return null;
	}
	
	@Override
	public AccountCreationStatus createSavingsAccount(String token, int custId) {

		System.out.println(custId);
		if (customerFeign.getDetails(token, custId) != null) {
			Account savingsAcc = accountRepo.save(new Account(Account.AccSeq++, custId, 200, "SAVINGS", null));
			return new AccountCreationStatus(savingsAcc.getAccountId(), "SAVINGS ACCOUNTS IS CREATED");
		}
		return null;
	}
	
	@Override
	public AccountCreationStatus createCurrentAccount(String token, int custId) {

		System.out.println(custId);
		if (customerFeign.getDetails(token, custId) != null) {
			Account currentAcc = accountRepo.save(new Account(Account.AccSeq++, custId, 200, "CURRENT", null));
			return new AccountCreationStatus(currentAcc.getAccountId(), "SAVINGS & CURRENT ACCOUNTS ARE CREATED");
		}
		return null;
	}

	@Override
	public List<Account> getCustomerAccounts(int custId) {

		return accountRepo.findByCustomerId(custId);
	}

	@Override
	public Account getAccount(long accountId) {

		return accountRepo.findByAccountId(accountId);
	}

	@Override
	public Statement getAccountStatement(long accId, LocalDate from, LocalDate to) {

		return new Statement();
	}

	/*
	 * deposit will be called from the transaction.. Account service needs to check
	 * the token validity. token will be attached by the transaction service
	 */

	@Override
	public TransactionStatus deposit(long AccountId, double amount) {
		Account acc = accountRepo.findByAccountId(AccountId);
		TransactionStatus ts = new TransactionStatus();
		double updatedBal = acc.getCurrentBalance() + amount;
		ts.setSource_balance(updatedBal);
		ts.setMessage("Current Balance displayed");
		acc.setCurrentBalance(updatedBal);
		accountRepo.save(acc);
		return ts;
	}

	/*
	 * withdraw will be called from the transaction.. Account service needs to check
	 * the token validity. token will be attached by the transaction service
	 */

	@Override
	public TransactionStatus withdraw(long AccountId, double amount) {
		Account acc = accountRepo.findByAccountId(AccountId);
		TransactionStatus ts = new TransactionStatus();
		double updatedBal = acc.getCurrentBalance() - amount;
		ts.setSource_balance(updatedBal);
		ts.setMessage("Current Balance displayed");
		acc.setCurrentBalance(updatedBal);
		accountRepo.save(acc);
		return ts;
	}

	/*
	 * transfer will be called from the transaction.. Account service needs to check
	 * the token validity. token will be attached by the transaction service
	 */

	@Override
	public TransactionStatus transfer(long From_AccId, long To_AccId, double amount) {
		Account srcAcc = accountRepo.findByAccountId(From_AccId);
		Account destAcc = accountRepo.findByAccountId(To_AccId);
		TransactionStatus ts = new TransactionStatus();
		double srcBal = srcAcc.getCurrentBalance() - amount;
		double destBal = destAcc.getCurrentBalance() + amount;
		ts.setSource_balance(srcBal);
		ts.setDestination_balance(destBal);
		ts.setMessage("Transaction done");
		srcAcc.setCurrentBalance(srcBal);
		destAcc.setCurrentBalance(destBal);
		accountRepo.save(srcAcc);
		accountRepo.save(destAcc);
		return ts;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}
	
	@Override
	public boolean deleteAccount(int custId) {
	
		accountRepo.deleteByCustomerId(custId);
		return true;
	}


}
