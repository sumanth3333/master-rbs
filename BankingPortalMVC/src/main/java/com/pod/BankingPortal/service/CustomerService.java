package com.pod.BankingPortal.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.feign.AccountFeign;
import com.pod.BankingPortal.feign.CustomerFeign;
import com.pod.BankingPortal.model.Account;
import com.pod.BankingPortal.model.Customer;
import com.pod.BankingPortal.service.interfaces.CustomerServiceInterface;

@Service
public class CustomerService implements CustomerServiceInterface {
	@Autowired
	CustomerFeign customerFeign;

	@Autowired
	AccountFeign accountFeign;

	@Override
	public ModelAndView postCreateCustomer(Customer customer, HttpSession session) {
		customer.setCustomerId(Customer.CUSTOMER_ID++);
		String token = (String) session.getAttribute("token");
		customerFeign.createCustomer(token, customer);
		return new ModelAndView("create_customer");
	}

	@Override
	public ModelAndView getCreateCustomer(HttpSession session, Model model) {
		model.addAttribute(new Customer());
		String role = (String) session.getAttribute("role");
		if (session.getAttribute("token") == null || !role.equalsIgnoreCase("employee")) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("create_customer");
	}

	@Override
	public ModelAndView getCustomerDetails(HttpSession session, Model model) {
		String role = (String) session.getAttribute("role");
		if (session.getAttribute("token") == null || !role.equalsIgnoreCase("customer")) {
			return new ModelAndView("redirect:/");
		}
		String token = (String) session.getAttribute("token");
		Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
		model.addAttribute("customer", cust);
		List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
		model.addAttribute("accounts", custAccs);
		return new ModelAndView("customer_details");
	}

	@Override
	public ModelAndView postDelete(HttpSession session, int customerId, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("customerLogin");
		} else {
			String token = (String) session.getAttribute("token");
			boolean deleteSuccess = customerFeign.deleteCustomer(token, customerId);
			if (deleteSuccess) {
				model.addAttribute("delete", "Customer deleted successfully");
				return new ModelAndView("Delete_customer", model);
			} else {
				model.addAttribute("delete", "Customer Doesn't exist");
				return new ModelAndView("Delete_customer", model);
			}
		}
	}

	@Override
	public ModelAndView deleteGet(HttpSession session) {
		if (session.getAttribute("token") == null)
			return new ModelAndView("employeeLogin");
		else
			return new ModelAndView("Delete_customer");
	}
}
