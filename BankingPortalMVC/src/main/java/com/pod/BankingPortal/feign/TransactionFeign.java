package com.pod.BankingPortal.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod.BankingPortal.model.Account;
import com.pod.BankingPortal.model.AccountSummary;
import com.pod.BankingPortal.model.Transaction;
import com.pod.BankingPortal.model.TransactionInput;

@FeignClient(name = "transaction-ms", url = "${feign.url-transaction-service}")
public interface TransactionFeign {

	@PostMapping("/withdraw")
	public boolean makeWithdraw(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput);

	/*
	 * feign method to check account balance
	 */
	// consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE
	@PostMapping(value = "/accounts")
	public Account checkAccountBalance(@Valid @RequestBody AccountSummary accountInput);

	/*
	 * feign class to make transfer the amount to another account
	 */
	@PostMapping(value = "/transfer")
	public boolean makeTransfer(@RequestHeader("Authorization") String token,
			 @RequestBody TransactionInput transactionInput);
	/*
	 * feign method to get all transactions by accountId
	 */
	@PostMapping(value = "/getAllTransByAccId")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@RequestBody long accId);

	/*
	 * feign method to get all Service charges by accountId
	 */
	@PostMapping(value = "/servicecharge")
	public boolean makeServiceCharges(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput);
	
	@PostMapping("/deposit")
	public boolean makeDeposit(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput);
}