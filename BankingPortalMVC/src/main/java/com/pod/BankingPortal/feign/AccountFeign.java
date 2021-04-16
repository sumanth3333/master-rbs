package com.pod.BankingPortal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod.BankingPortal.model.Account;
import com.pod.BankingPortal.model.AccountCreationStatus;

@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {

	@PostMapping("/createAccount")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
			 int customerId);
	
	@PostMapping("/createCurrentAccount")
	public AccountCreationStatus createCurrentAccount(@RequestHeader("Authorization") String token, @RequestBody int custId);
	
	@PostMapping("/createSavingsAccount")
	public AccountCreationStatus createSavingsAccount(@RequestHeader("Authorization") String token, @RequestBody int custId);

	@PostMapping("/getCustomerAccounts")
	public List<Account> getCustomerAccounts(@RequestHeader("Authorization") String token,
			@RequestBody int customerId);

}
