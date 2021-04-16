package com.pod.service;

import java.time.LocalDate;
import java.util.List;

import com.pod.models.Account;
import com.pod.models.AccountCreationStatus;
import com.pod.models.Statement;
import com.pod.models.TransactionStatus;

public interface AccountServiceInterface {

	public AccountCreationStatus createAccount(String token,int custId);
	
	public List<Account> getCustomerAccounts(int custId);
	
	public Account getAccount(long accountId);
	
	public Statement getAccountStatement(long accId,LocalDate from,LocalDate to);
	
	public TransactionStatus deposit(long AccountId,double amount);
	
	public TransactionStatus withdraw(long AccountId,double amount);
	
	public TransactionStatus transfer(long From_AccId,long To_AccId,double amount);

	public List<Account> getAllAccounts();

	AccountCreationStatus createSavingsAccount(String token, int custId);

	AccountCreationStatus createCurrentAccount(String token, int custId);

	public boolean deleteAccount(int custId);
}
