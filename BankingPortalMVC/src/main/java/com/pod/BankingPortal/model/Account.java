package com.pod.BankingPortal.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	public static long AccSeq = 1000000000;

	@NotNull(message = "Enter Account number")
	private long accountId;

	@NotBlank(message = "Enter customerId")
	private String customerId;

	@NotNull(message = "Enter currentBalance")
	private double currentBalance;

	@NotBlank(message = "Enter accountType")
	private String accountType;

	private List<Transaction> transactions;

}