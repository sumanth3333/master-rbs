package com.pod.BankingPortal.service.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.model.User;

public interface LoginServiceInterface {

	public ModelAndView postCustomerLogin(HttpSession session, User user, Model model);

	public ModelAndView postEmployeeLogin(HttpSession session, User user,Model model);

	public ModelAndView getCustomerLogin(HttpSession session, Model model);

	public ModelAndView getEmployeeLogin(HttpSession session, Model model);

	public ModelAndView getHomePage(HttpSession session, Model model);
}
