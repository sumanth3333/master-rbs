package com.pod.BankingPortal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.model.Customer;
import com.pod.BankingPortal.service.interfaces.CustomerServiceInterface;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceInterface customerService;

	@GetMapping("/delete")
	public ModelAndView deletePage(HttpSession session, ModelMap model) {
		return customerService.deleteGet(session);

	}

	@PostMapping("/deleteCustomer")
	public ModelAndView delete(HttpSession session, @RequestParam int customerId, ModelMap model) {
		return customerService.postDelete(session, customerId, model);
	}

	@GetMapping("/customerDetails")
	public ModelAndView getCustomerDetails(HttpSession session, Model model) {
		return customerService.getCustomerDetails(session, model);
	}

	@GetMapping("/createCustomer")
	public ModelAndView createCustomer(HttpSession session, Model model) {
		return customerService.getCreateCustomer(session, model);
	}

	@PostMapping("/customerCreation")
	public ModelAndView customerCreation(@ModelAttribute Customer customer, HttpSession session, Model model) {
		return customerService.postCreateCustomer(customer, session);
	}

}