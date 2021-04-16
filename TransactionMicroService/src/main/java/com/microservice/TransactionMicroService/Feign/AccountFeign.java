package com.microservice.TransactionMicroService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.microservice.TransactionMicroService.Model.Account;
import com.microservice.TransactionMicroService.Model.TransactionStatus;

@FeignClient(name = "account-ms", url = "http://localhost:8081")
public interface AccountFeign {

	@GetMapping("/getAccount/{accountId}")
	public Account getAccount(@RequestHeader("Authorization") String token,
			@PathVariable(name = "accountId") long accountId);

	@PostMapping("/deposit/{AccountId}/{amount}")
	public TransactionStatus deposit(@RequestHeader("Authorization") String token,
			@PathVariable(name = "AccountId") long AccountId, @PathVariable(name = "amount") double amount);

	@PostMapping("/withdraw/{AccountId}/{amount}")
	public TransactionStatus withdraw(@RequestHeader("Authorization") String token,
			@PathVariable("AccountId") long AccountId, @PathVariable("amount") double amount);

	@PostMapping("/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
	public TransactionStatus transfer(@RequestHeader("Authorization") String token,
			@PathVariable("sourceAccountId") long sourceAccountId,
			@PathVariable("targetAccountId") long targetAccountId, @PathVariable("amount") double amount);

	@PostMapping("/hello")
	public String sayHi(@RequestHeader("joshPatti") String uname);

}
