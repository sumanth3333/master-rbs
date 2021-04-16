package com.cts.RulesService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RulesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RulesServiceApplication.class, args);
	}

}
