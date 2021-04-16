package com.pod.BankingPortal.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Customer {

	public static int CUSTOMER_ID = 1020;
	
	private int customerId;

	@NonNull
	private String username;

	@NonNull
	private String password;

	@NonNull
	private String address;
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@NonNull
	@Pattern(regexp = "^[A-Z]{5}+[0-9]{4}+[A-Z]{1}$")
	private String panNo;

	private long aadharNo;

	private long phoneNumber;
	@Email(message = "Email should be valid")
	private String emailId;

	private CustomerCreationStatus createStatus;

	public Customer(String username, String password, String address, LocalDate dob, String panNo, long aadharNo,
			long phoneNumber, String emailId) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.panNo = panNo;
		this.aadharNo = aadharNo;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

}
