package com.pod.BankingPortal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.service.interfaces.RulesServiceInterface;

@RestController
public class RulesController {

	@Autowired
	private RulesServiceInterface rulesService;

	@GetMapping("/serviceCharge")
	public ModelAndView serviceCharge(HttpSession session) {
		return rulesService.getServiceTax(session);
	}

	@PostMapping("/deductServiceTax")
	public ModelAndView serviceChargeDeduct(HttpSession session) {
		return rulesService.postServiceTax(session);
	}
}