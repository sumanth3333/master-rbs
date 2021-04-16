package com.pod.BankingPortal.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.feign.RulesFeign;
import com.pod.BankingPortal.service.interfaces.RulesServiceInterface;

@Service
public class RulesService implements RulesServiceInterface{

	@Autowired
	RulesFeign rulesFeign;
	
	@Override
	public ModelAndView postServiceTax(HttpSession session) {
		String role = (String) session.getAttribute("role");
		String token = (String) session.getAttribute("token");
		if (role.equalsIgnoreCase("employee")) {
			rulesFeign.getServiceCharges(token);
			return new ModelAndView("Deduction");
		} else {
			return new ModelAndView("AccessDenied");
		}
	}

	@Override
	public ModelAndView getServiceTax(HttpSession session) {
		String role = (String) session.getAttribute("role");
		if (session.getAttribute("token") == null || !role.equalsIgnoreCase("employee")) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("Deduction");
	}

}
