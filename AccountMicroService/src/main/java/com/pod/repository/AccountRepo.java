package com.pod.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pod.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	public List<Account> findByCustomerId(int custId);
	
	public Account findByAccountId(long accountId);
	
	@Transactional
	public int deleteByCustomerId(int custId);
	//getAccountStatement
	
	
}
