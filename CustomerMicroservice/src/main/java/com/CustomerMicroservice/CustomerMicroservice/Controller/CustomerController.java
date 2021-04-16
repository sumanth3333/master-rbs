package com.CustomerMicroservice.CustomerMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerMicroservice.CustomerMicroservice.Feign.AccountFeign;
import com.CustomerMicroservice.CustomerMicroservice.Model.Customer;
import com.CustomerMicroservice.CustomerMicroservice.Service.CustomerServiceInterface;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerService;

	@Autowired
	private AccountFeign accountFeign;

	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestHeader("Authorization") String token, @RequestBody Customer customer) {
		System.out.println(customer);
		return customerService.createCustomer(token, customer);

	}

//	
	@GetMapping("/getCustomerDetail/{id}")
	public Customer getDetails(@RequestHeader("Authorization") String token, @PathVariable int id) {

		return customerService.getCustomerDetail(token, id);
	}

	@DeleteMapping("/deleteCustomer")
	public boolean deleteCustomer(@RequestHeader("Authorization") String token, @RequestBody int id) {

		System.out.println(id);
		return customerService.deleteCustomer(token, id);
	}
//	
}
