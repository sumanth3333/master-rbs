package com.cognizant.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cognizant.authenticationservice.exceptionhandling.AppUserNotFoundException;
import com.cognizant.authenticationservice.model.AppUser;
import com.cognizant.authenticationservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginService {

	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private CustomerDetailsService customerDetailservice;

	public AppUser userLogin(AppUser appuser) throws AppUserNotFoundException {
		final MyUserDetails userdetails = customerDetailservice.loadUserByUsername(appuser.getUsername());
		String username = "";
		String role = "";
		String token = "";

		log.info("Password From DB-->{}", userdetails.getPassword());
		log.info("Password From Request-->{}", encoder.encode(appuser.getPassword()));

		if (userdetails.getPassword().equals(appuser.getPassword())) {
			username = appuser.getUsername();
			token = jwtutil.generateToken(userdetails);
			role = userdetails.getRole();
			return new AppUser(userdetails.getUser().getUserid(), username, null, token, role);
		} else {
			throw new AppUserNotFoundException("Username/Password is incorrect...Please check");
		}
	}

	public boolean deleteUser(String userId) {

		userRepo.deleteByUserid(userId);
		return true;

	}
}