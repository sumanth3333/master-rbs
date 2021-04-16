package com.microservice.TransactionMicroService.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.TransactionMicroService.Feign.AccountFeign;
import com.microservice.TransactionMicroService.Feign.RulesFeign;
import com.microservice.TransactionMicroService.Model.Account;
import com.microservice.TransactionMicroService.Model.AccountSummary;
import com.microservice.TransactionMicroService.Model.Transaction;
import com.microservice.TransactionMicroService.Model.TransactionInput;
import com.microservice.TransactionMicroService.Repository.TransactionRepository;

@Service
public class TransactionService implements TransactionServiceInterface {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountFeign accountFeign;

	@Autowired
	RulesFeign rulesFeign;

	@Override
	public boolean makeDeposit(String token, AccountSummary accountSummary) {

		Account sourceAccount = null;

		long accNumber = accountSummary.getAccountId();
		sourceAccount = accountFeign.getAccount(token, accNumber);

		if (sourceAccount != null) {
			accountFeign.deposit(token, accountSummary.getAccountId(), accountSummary.getAmount());
			Transaction transaction = new Transaction();
			transaction.setSourceAccountId(sourceAccount.getAccountId());
			transaction.setSourceOwnerName(sourceAccount.getOwnerName());
			transaction.setTargetAccountId(sourceAccount.getAccountId());
			transaction.setTargetOwnerName(sourceAccount.getOwnerName());
			transaction.setInitiationDate(LocalDateTime.now());
			transaction.setReference("deposit");
			transaction.setAmount(accountSummary.getAmount());
			transactionRepository.save(transaction);
			return true;
		}
		return false;

	}

	@Override
	public boolean makeWithdraw(String token, AccountSummary accountSummary) {

		Account sourceAccount = null;
		boolean status = false;
		long accNumber = accountSummary.getAccountId();
		sourceAccount = accountFeign.getAccount(token, accNumber);

		if (sourceAccount != null && accountSummary.getAmount() <= sourceAccount.getCurrentBalance()) {

			if (!rulesFeign.evaluate(token, sourceAccount.getCurrentBalance())) {
				status = false;
			} else {
				accountFeign.withdraw(token, accountSummary.getAccountId(), accountSummary.getAmount());
				Transaction transaction = new Transaction();
				transaction.setSourceAccountId(sourceAccount.getAccountId());
				transaction.setSourceOwnerName(sourceAccount.getOwnerName());
				transaction.setTargetAccountId(sourceAccount.getAccountId());
				transaction.setTargetOwnerName(sourceAccount.getOwnerName());
				transaction.setInitiationDate(LocalDateTime.now());
				transaction.setReference("withdraw");
				transaction.setAmount(accountSummary.getAmount());
				transactionRepository.save(transaction);
				status = true;
			}
		}
		return status;
	}

	@Override
	public boolean makeTransfer(String token, TransactionInput transactionInput) {

		Account sourceAccount = null;
		Account targetAccount = null;
		boolean status = false;
		long sourceAccountId = transactionInput.getSourceAccount();
		System.out.println(sourceAccountId);
		long targetAccountId = transactionInput.getTargetAccount();
		sourceAccount = accountFeign.getAccount(token, sourceAccountId);
		targetAccount = accountFeign.getAccount(token, targetAccountId);

		if ((sourceAccount != null && targetAccount != null)
				&& (transactionInput.getAmount() <= sourceAccount.getCurrentBalance())) {

			if (!rulesFeign.evaluate(token, sourceAccount.getCurrentBalance())) {
				status = false;
			} else {
				accountFeign.transfer(token, sourceAccountId, targetAccountId, transactionInput.getAmount());
				Transaction transaction = new Transaction();
				transaction.setSourceAccountId(sourceAccount.getAccountId());
				transaction.setSourceOwnerName(sourceAccount.getOwnerName());
				transaction.setTargetAccountId(targetAccount.getAccountId());
				transaction.setTargetOwnerName(targetAccount.getOwnerName());
				transaction.setInitiationDate(LocalDateTime.now());
				transaction.setReference("transfer");
				transaction.setAmount(transactionInput.getAmount());
				transactionRepository.save(transaction);
				status = true;
			}
		}
		return status;

	}

//	@Override
//	public Transaction getTransaction(long customerId) {
//		// TODO Auto-generated method stub
//		System.out.println(transactionRepository.findBySourceAccountId(customerId));
//		return transactionRepository.findBySourceAccountId(customerId);
//	}

	@Override
	public List<Transaction> getTransactionsByAccId(String token, long accId) {
		return transactionRepository.findBySourceAccountId(accId);
		
	}

}
