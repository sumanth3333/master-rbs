package com.pod.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TransactionStatus {

	@Id
	@GeneratedValue
	private int tId;
	private String message;
	private double source_balance;
	private double destination_balance;
	
}
