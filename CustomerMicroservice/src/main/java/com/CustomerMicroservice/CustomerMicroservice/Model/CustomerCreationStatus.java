package com.CustomerMicroservice.CustomerMicroservice.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CustomerCreationStatus {

	@Id
	@GeneratedValue
	private int createStatusId;
	@OneToOne(mappedBy="createStatus")
	private Customer customer;
	
	private String message;

	public CustomerCreationStatus(Customer customer, String message) {
		super();
		this.customer = customer;
		this.message = message;
	}
	
	
	
}
