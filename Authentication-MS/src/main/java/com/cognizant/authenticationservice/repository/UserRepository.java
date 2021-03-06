package com.cognizant.authenticationservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

	AppUser findByUsername(String username);

	@Transactional
	public int deleteByUserid(String userid);
}