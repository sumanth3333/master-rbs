package com.pod.BankingPortal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod.BankingPortal.model.Customer;

@FeignClient(name = "customer", url = "${feign.url-customer-service}")
public interface CustomerFeign {
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestHeader("Authorization") String token, @RequestBody Customer customer);

	@GetMapping("/getCustomerDetail/{id}")
	public Customer getDetails(@RequestHeader("Authorization") String token, @PathVariable int id);
	
	@DeleteMapping("/deleteCustomer")
	public boolean deleteCustomer(@RequestHeader("Authorization") String token, @RequestBody int id);
}