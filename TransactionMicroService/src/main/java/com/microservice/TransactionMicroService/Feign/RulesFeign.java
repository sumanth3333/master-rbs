package com.microservice.TransactionMicroService.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.microservice.TransactionMicroService.Model.Account;
import com.microservice.TransactionMicroService.Model.ServiceChargeResponse;



@FeignClient(name = "rules-ms", url = "${feign.url-rule-service}")
public interface RulesFeign {
	
	@GetMapping("/evaluateMinBal/{bal}")
	public boolean evaluate(@RequestHeader("Authorization") String token,@PathVariable("bal") double bal);
	
	@GetMapping("/getServiceCharges")
	public List<ServiceChargeResponse> getServiceCharges(@RequestHeader("Authorization") String token);
	

}
