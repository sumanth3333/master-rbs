package com.cts.RulesService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.RulesService.model.Account;

@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {

	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccounts(@RequestHeader("Authorization") String token);
	
	@PostMapping("/saveAccount")
	public void saveAcc(@RequestHeader("Authorization") String token,@RequestBody Account account);
}
