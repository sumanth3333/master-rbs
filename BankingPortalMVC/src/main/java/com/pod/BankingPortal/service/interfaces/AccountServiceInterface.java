package com.pod.BankingPortal.service.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface AccountServiceInterface {

	public ModelAndView postCreateAccount(HttpSession session, int customerId, String accType);
	
	public ModelAndView getCreateAccount(HttpSession session);
}
