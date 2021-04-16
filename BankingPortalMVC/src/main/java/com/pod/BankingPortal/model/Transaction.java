package com.pod.BankingPortal.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Transaction {

	private int transactionId;
	private long sourceAccountId;
	private String sourceOwnerName;

	private long targetAccountId;

	private String targetOwnerName;

	private double amount;

	private LocalDateTime initiationDate;

	private String reference;

	public Transaction(long sourceAccountId, String sourceOwnerName, long targetAccountId, String targetOwnerName,
			double amount, LocalDateTime initiationDate, String reference) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.sourceOwnerName = sourceOwnerName;
		this.targetAccountId = targetAccountId;
		this.targetOwnerName = targetOwnerName;
		this.amount = amount;
		this.initiationDate = initiationDate;
		this.reference = reference;
	}
	
	
	

}
