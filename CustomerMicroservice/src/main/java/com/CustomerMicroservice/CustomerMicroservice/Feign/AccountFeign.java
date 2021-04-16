package com.CustomerMicroservice.CustomerMicroservice.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.CustomerMicroservice.CustomerMicroservice.Model.Account;
import com.CustomerMicroservice.CustomerMicroservice.Model.AccountCreationStatus;


@FeignClient(name = "account-ms", url = "http://localhost:8081")
public interface AccountFeign {
	

	@PostMapping("/createAccount")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
			 int customerId);
	
	@GetMapping("/getCustomerAccounts")
	public List<Account> getCustomerAccounts(@RequestHeader("Authorization") String token,
			 int customerId);

	@DeleteMapping("/delete")
	public boolean delete(@RequestHeader("Authorization") String token, @RequestBody int custId);
}
