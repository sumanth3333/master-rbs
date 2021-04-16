package com.microservice.TransactionMicroService.ExceptionHandling;

public class MinimumBalanceException extends RuntimeException{

	/**
	 * MinimumBalance Exception
	 */

	public MinimumBalanceException() {
		super();
	}

	public MinimumBalanceException(String message) {
		super(message);
	}

	
	
}
