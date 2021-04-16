package com.microservice.TransactionMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransactionMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionMicroServiceApplication.class, args);
	}

}
