package com.pod.BankingPortal.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.feign.AccountFeign;
import com.pod.BankingPortal.service.interfaces.AccountServiceInterface;

@Service
public class AccountService implements AccountServiceInterface {

	@Autowired
	AccountFeign accountFeign;

	@Override
	public ModelAndView postCreateAccount(HttpSession session, int customerId, String accType) {
		String token = (String) session.getAttribute("token");
		if (accType.equalsIgnoreCase("savings")) {
			accountFeign.createSavingsAccount(token, customerId);
		} else {
			accountFeign.createCurrentAccount(token, customerId);
		}
		return new ModelAndView("create_account");
	}

	@Override
	public ModelAndView getCreateAccount(HttpSession session) {
		String role = (String) session.getAttribute("role");
		if (session.getAttribute("token") == null || !role.equalsIgnoreCase("employee")) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("create_account");
	}

}
