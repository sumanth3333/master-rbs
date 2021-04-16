package com.pod.BankingPortal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerCreationStatus {

	private int createStatusId;
	private Customer customer;

	private String message;

	public CustomerCreationStatus(Customer customer, String message) {
		super();
		this.customer = customer;
		this.message = message;
	}

}
