package com.CustomerMicroservice.CustomerMicroservice.Service;

import com.CustomerMicroservice.CustomerMicroservice.Model.AuthenticationResponse;
import com.CustomerMicroservice.CustomerMicroservice.Model.Customer;

public interface CustomerServiceInterface {
	

		public Customer createCustomer(String token,Customer customer);

		public Customer getCustomerDetail(String token,String uname);
		
		public Customer getCustomerDetail(String token,int id);

		public AuthenticationResponse hasEmployeePermission(String token);

		public boolean deleteCustomer(String token,int id);

		public AuthenticationResponse hasCustomerPermission(String token);

		public AuthenticationResponse hasPermission(String token);

		public Customer updateCustomer(String token,Customer customer);




}
