package com.pod.BankingPortal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.service.interfaces.AccountServiceInterface;

@RestController
public class AccountController {

	@Autowired
	private AccountServiceInterface accountService;

	@GetMapping("/createAccount")
	public ModelAndView createAccount(HttpSession session) {
		return accountService.getCreateAccount(session);
	}

	@PostMapping("/createAccount")
	public ModelAndView createAccount(HttpSession session, @RequestParam int customerId, @RequestParam String accType) {
		return accountService.postCreateAccount(session, customerId, accType);
	}

}