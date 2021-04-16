package com.microservice.TransactionMicroService.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TransactionStatus {
	
	@Id
	private int transactionId;
	private String statusMessage;

}
