package com.microservice.TransactionMicroService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.TransactionMicroService.Model.TransactionStatus;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer>{

}
