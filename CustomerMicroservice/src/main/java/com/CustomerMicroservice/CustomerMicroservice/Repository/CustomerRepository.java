package com.CustomerMicroservice.CustomerMicroservice.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerMicroservice.CustomerMicroservice.Model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByCustomerId(int id);
	
	public Customer findByUsername(String uname);

	@Transactional
	public void deleteByCustomerId(int id);

	
}
