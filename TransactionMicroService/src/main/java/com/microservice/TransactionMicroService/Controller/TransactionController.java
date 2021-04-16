package com.microservice.TransactionMicroService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.TransactionMicroService.Feign.AccountFeign;
import com.microservice.TransactionMicroService.Model.AccountSummary;
import com.microservice.TransactionMicroService.Model.Transaction;
import com.microservice.TransactionMicroService.Model.TransactionInput;
import com.microservice.TransactionMicroService.Service.TransactionServiceInterface;

@RestController
public class TransactionController {

	@Autowired
	TransactionServiceInterface transactionService;

	@Autowired
	AccountFeign accountFeign;

	@PostMapping("/deposit")
	public boolean makeDeposit(@RequestHeader("Authorization") String token,
			@RequestBody AccountSummary accountSummary) {

		transactionService.makeDeposit(token, accountSummary);
		return true;

	}

	@PostMapping("/withdraw")
	public boolean makeWithdraw(@RequestHeader("Authorization") String token,
			@RequestBody AccountSummary accountSummary) {

		return transactionService.makeWithdraw(token, accountSummary);

	}

	@PostMapping("/transfer")
	public boolean makeTransfer(@RequestHeader("Authorization") String token,
			@RequestBody TransactionInput transactionInput) {

		return transactionService.makeTransfer(token, transactionInput);

	}

//	@GetMapping("/getTransaction/{customerId}")
//	public Transaction getTransaction(@RequestHeader("Authorization") String token, @PathVariable long customerId) {
//
//		return transactionService.getTransaction(customerId);
//
//	}
	
	@PostMapping(value = "/getAllTransByAccId")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@RequestBody long accId){
		return transactionService.getTransactionsByAccId(token,accId);
	}

	@PostMapping("/hello")
	public String sayHello() {
		String uname = "josh";
		return accountFeign.sayHi(uname);
	}
}
