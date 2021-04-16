package com.pod.BankingPortal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.model.User;
import com.pod.BankingPortal.service.interfaces.LoginServiceInterface;

@RestController
public class LoginController {
	@Autowired
	public LoginServiceInterface loginService;

	@GetMapping({ "/", "login", "home" })
	public ModelAndView home(HttpSession session, Model model) {
		return loginService.getHomePage(session, model);
	}

	@GetMapping("/employeeLogin")
	public ModelAndView employeeLogin(HttpSession session, Model model) {
		return loginService.getEmployeeLogin(session, model);
	}

	@GetMapping("/customerLogin")
	public ModelAndView customerLogin(HttpSession session, Model model) {
		return loginService.getCustomerLogin(session, model);
	}

	@PostMapping(value = "/employeeLogin")
	public ModelAndView employeeLogin(HttpSession session, @ModelAttribute("user") User user, Model model) {
		return loginService.postEmployeeLogin(session, user, model);
	}

	@PostMapping(value = "/customerLogin")
	public ModelAndView customerLogin(HttpSession session, @ModelAttribute("user") User user, Model model) {
		return loginService.postCustomerLogin(session, user, model);
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		if(session.getAttribute("token")==null) {
			return new ModelAndView("redirect:/login");
		}
		session.invalidate();
		return new ModelAndView("logout");
	}
}