package com.CustomerMicroservice.CustomerMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.CustomerMicroservice.CustomerMicroservice.Exception.AccessDeniedException;
import com.CustomerMicroservice.CustomerMicroservice.Feign.AccountFeign;
import com.CustomerMicroservice.CustomerMicroservice.Feign.AuthorizationFeign;
import com.CustomerMicroservice.CustomerMicroservice.Model.User;
import com.CustomerMicroservice.CustomerMicroservice.Model.AuthenticationResponse;
import com.CustomerMicroservice.CustomerMicroservice.Model.Customer;
import com.CustomerMicroservice.CustomerMicroservice.Repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AuthorizationFeign authorizationFeign;

	@Autowired
	AccountFeign accountFeign;

	public Customer createCustomer(@RequestHeader("Authorization") String token, Customer customer) {

		Customer cust = getCustomerDetail(token, customer.getUsername());
		if (cust == null) {
			customerRepository.save(customer);
			User user = new User(customer.getCustomerId(), customer.getUsername(), customer.getPassword(), null,
					"customer");
			authorizationFeign.createUser(user);
			accountFeign.createAccount(token, customer.getCustomerId());
		}
		return cust;
	}

	public Customer getCustomerDetail(@RequestHeader("Authorization") String token, String uname) {

		return customerRepository.findByUsername(uname);
	}

	@Override
	public boolean deleteCustomer(@RequestHeader("Authorization") String token, int id) {

		Customer customer = null;
		customer = getCustomerDetail(token, id);
		if (customer == null) {
			return false;
		}
		accountFeign.delete(token, id);
		authorizationFeign.delete(token, id);
		System.out.println("Starting deletion of-->" + id);
		customerRepository.deleteByCustomerId(id);
		System.out.println("Deleted");
		return true;

	}

	@Override
	public Customer updateCustomer(@RequestHeader("Authorization") String token, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthenticationResponse hasPermission(String token) {
		return authorizationFeign.getValidity(token);
	}

	@Override
	public AuthenticationResponse hasEmployeePermission(String token) {
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	@Override
	public AuthenticationResponse hasCustomerPermission(String token) {
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("CUSTOMER"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	@Override
	public Customer getCustomerDetail(String token, int id) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerId(id);
	}

}
