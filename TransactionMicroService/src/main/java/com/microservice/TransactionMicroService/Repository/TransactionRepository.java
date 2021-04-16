package com.microservice.TransactionMicroService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.TransactionMicroService.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

//	public Transaction findBySourceAccountId(long customerId);

	public List<Transaction> findBySourceAccountId(long accountId);
}
