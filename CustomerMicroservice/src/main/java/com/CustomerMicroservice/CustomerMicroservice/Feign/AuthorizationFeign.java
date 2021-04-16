package com.CustomerMicroservice.CustomerMicroservice.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.CustomerMicroservice.CustomerMicroservice.Model.AuthenticationResponse;
import com.CustomerMicroservice.CustomerMicroservice.Model.User;

@FeignClient(name = "auth-service", url = "${feign.url-auth-service}")
@Component
public interface AuthorizationFeign {

	// Create Consumer
	@PostMapping(value = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody User appUserCredentials);

	// Customer login
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody User appUserloginCredentials);

	@GetMapping(value = "/validateToken")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);

	@GetMapping("/role/{id}")
	public String getRole(@PathVariable("id") String id);

	@DeleteMapping("/delete")
	public boolean delete(@RequestHeader("Authorization") String token, @RequestBody int custId);
}
