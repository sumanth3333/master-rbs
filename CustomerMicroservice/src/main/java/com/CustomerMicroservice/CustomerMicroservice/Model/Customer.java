package com.CustomerMicroservice.CustomerMicroservice.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	
	@Id
	private int customerId;
	
	@NonNull
	@Column(unique = true)
	private String username;
	
	@NonNull
	private String password;
	
	@NonNull
	private String address;
	@NonNull
	private LocalDate dob;
	
	@NonNull
	@Pattern(regexp = "^[A-Z]{5}+[0-9]{4}+[A-Z]{1}$")
	@Column(unique = true)
	private String panNo;

	@Column(length = 12,unique = true)
	private long aadharNo;

	@Column(length = 10,unique = true)
	private long phoneNumber;
	@Email(message = "Email should be valid")
	private String emailId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private CustomerCreationStatus createStatus;
	
	public Customer(@NonNull String username, @NonNull String password, @NonNull String address, @NonNull LocalDate dob,
			@NonNull String panNo, long aadharNo, long phoneNumber,
			@Email(message = "Email should be valid") String emailId) {
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
