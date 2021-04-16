package com.microservice.TransactionMicroService.Service;

import java.util.List;

import com.microservice.TransactionMicroService.Model.AccountSummary;
import com.microservice.TransactionMicroService.Model.Transaction;
import com.microservice.TransactionMicroService.Model.TransactionInput;

public interface TransactionServiceInterface {

	public boolean makeDeposit(String token, AccountSummary accountSummary);

	public boolean makeWithdraw(String token, AccountSummary accountSummary);

	public boolean makeTransfer(String token, TransactionInput transactionInput);

//	Transaction getTransaction(long customerId);

	public List<Transaction> getTransactionsByAccId(String token, long accId);

}
