package com.pod.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.Transaction;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	public static long AccSeq = 1000000020;
	@Id
	@NotNull(message = "Enter Account number")
	private long accountId;

	@NotNull
	private int customerId;

	@NotNull(message = "Enter currentBalance")
	private double currentBalance;

	@NotBlank(message = "Enter accountType")
	private String accountType;

	@Transient
	private List<Transaction> transactions;

}