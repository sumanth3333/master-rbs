package com.cts.RulesService.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.Transaction;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@NotNull(message = "Enter Account number")
	private long accountId;

	@NotBlank(message = "Enter customerId")
	private String customerId;

	@NotNull(message = "Enter currentBalance")
	private double currentBalance;

	@NotBlank(message = "Enter accountType")
	private String accountType;

	@Transient
	private List<Transaction> transactions;

}