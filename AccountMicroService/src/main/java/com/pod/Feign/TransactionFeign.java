package com.pod.Feign;


import java.util.List;

import javax.transaction.Transaction;
import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod.models.Account;
import com.pod.models.AccountSummary;
import com.pod.models.TransactionInput;

@FeignClient(name = "transaction-ms", url = "${feign.url-transaction-service}")
public interface TransactionFeign {

	
	/*
	 *  feign method to access deposit
	 */
	@PostMapping("/deposit")
	public ResponseEntity<?> makeDeposit(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput);

	 
	/*
	 *  feign method to access withdraw
	 */
	@PostMapping("/withdraw")
	public boolean makeWithdraw(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput) ;

	
	/*
	 *  feign method to check account balance
	 */
	//consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
	@PostMapping(value = "/accounts")
	public Account checkAccountBalance(@Valid @RequestBody AccountSummary accountInput);


	/*
	 *  feign class to make transfer the amount to another account
	 */
	@PostMapping(value = "/transactions")
	public boolean makeTransfer(@RequestHeader("Authorization") String token,@Valid @RequestBody TransactionInput transactionInput);
	
	
	/*
	 *  feign method to get all transactions by accountId
	 */
	@GetMapping(value = "/getAllTransByAccId/{id}")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@PathVariable("id") long accId);
	
	/*
	 *  feign method to get all Service charges by accountId
	 */
	@PostMapping(value = "/servicecharge")
	public boolean makeServiceCharges(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountSummary accountInput);
}