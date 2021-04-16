package com.pod.BankingPortal.service.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.model.Customer;

public interface CustomerServiceInterface {

	public ModelAndView postCreateCustomer(Customer customer, HttpSession session);

	public ModelAndView getCreateCustomer(HttpSession session, Model model);

	public ModelAndView getCustomerDetails(HttpSession session, Model model);
	
	public ModelAndView postDelete(HttpSession session, int customerId, ModelMap model);
	
	public ModelAndView deleteGet(HttpSession session);
	
}
