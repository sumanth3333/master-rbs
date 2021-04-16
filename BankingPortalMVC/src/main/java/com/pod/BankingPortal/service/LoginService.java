package com.pod.BankingPortal.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.feign.AuthFeign;
import com.pod.BankingPortal.model.User;
import com.pod.BankingPortal.service.interfaces.LoginServiceInterface;

@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	AuthFeign authFeign;

	public boolean checkUser(HttpSession session) {
		if (session.getAttribute("token") == null)
			return false;
		else
			return true;
	}

	@Override
	public ModelAndView postCustomerLogin(HttpSession session, User user, Model model) {
		if (checkUser(session)) {
			return new ModelAndView("redirect:/home");
		} else {
			User re = null;
			String role = "";
			try {
				re = authFeign.login(user);
				re = authFeign.login(user);
				role = re.getRole();

				if (role.equalsIgnoreCase("CUSTOMER")) {
					session.setAttribute("token", "Bearer " + re.getAuthToken());
					session.setAttribute("role", re.getRole());
					session.setAttribute("userId", re.getUserid());
					return new ModelAndView("redirect:/home");
				}

			} catch (Exception e) {
				model.addAttribute("errorMsg", "Invalid Credentials, Please try again.");
				return new ModelAndView("customerLogin");
			}
			return new ModelAndView("customerLogin");
		}
	}

	@Override
	public ModelAndView postEmployeeLogin(HttpSession session, User user, Model model) {
		if (checkUser(session)) {
			return new ModelAndView("redirect:/home");
		} else {
			User re = null;
			String role = "";
			try {
				re = authFeign.login(user);
				role = re.getRole();
				if (role.equalsIgnoreCase("EMPLOYEE")) {
					session.setAttribute("token", "Bearer " + re.getAuthToken());
					session.setAttribute("role", re.getRole());
					session.setAttribute("userId", re.getUserid());
					return new ModelAndView("redirect:/home");
				}

			} catch (Exception e) {
				model.addAttribute("errorMsg", "Invalid Credentials, Please try again.");
				return new ModelAndView("employeeLogin");
			}
			return new ModelAndView("employeeLogin");
		}
	}

	@Override
	public ModelAndView getCustomerLogin(HttpSession session, Model model) {
		model.addAttribute(new User());
		if (checkUser(session))
			return new ModelAndView("redirect:/home");
		else {
			return new ModelAndView("customerLogin");
		}
	}

	@Override
	public ModelAndView getEmployeeLogin(HttpSession session, Model model) {
		model.addAttribute(new User());
		if (!checkUser(session))
			return new ModelAndView("employeeLogin");
		else {
			return new ModelAndView("redirect:/home");
		}
	}

	@Override
	public ModelAndView getHomePage(HttpSession session, Model model) {
		model.addAttribute(new User());
		if (checkUser(session)) {
			String role = (String) session.getAttribute("role");
			ModelAndView op = null;
			if (role.equalsIgnoreCase("EMPLOYEE"))
				op = new ModelAndView("employeeDashboard");
			else if (role.equalsIgnoreCase("CUSTOMER"))
				op = new ModelAndView("customerDashboard");
			return op;
		} else {
			return new ModelAndView("employeeLogin");
		}
	}
}
