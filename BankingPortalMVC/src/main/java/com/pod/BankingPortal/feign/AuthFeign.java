package com.pod.BankingPortal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pod.BankingPortal.model.AuthenticationResponse;
import com.pod.BankingPortal.model.User;

@FeignClient(name = "auth-service", url = "${feign.url-auth-service}")
public interface AuthFeign {

	// Create Consumer
	@PostMapping(value = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody User appUserCredentials);

	// Customer login
	@PostMapping(value = "/login")
	public User login(@RequestBody User appUserloginCredentials);

	@GetMapping(value = "/validateToken")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);

	@GetMapping("/role/{id}")
	public String getRole(@PathVariable("id") String id);

}
