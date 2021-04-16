package com.pod.BankingPortal.service.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface RulesServiceInterface {

	public ModelAndView postServiceTax(HttpSession session);
	
	public ModelAndView getServiceTax(HttpSession session);
}
