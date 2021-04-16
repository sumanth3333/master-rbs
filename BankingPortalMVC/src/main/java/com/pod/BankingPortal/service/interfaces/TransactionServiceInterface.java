package com.pod.BankingPortal.service.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.model.AccountSummary;
import com.pod.BankingPortal.model.TransactionInput;

public interface TransactionServiceInterface {

	public ModelAndView postTransactionsList(HttpSession session, Model model, long accountId);

	public ModelAndView getTransactionsList(HttpSession session, Model model);

	public ModelAndView postDeposit(HttpSession session, AccountSummary accountInput, ModelMap model);

	public ModelAndView getDeposit(HttpSession session, ModelMap model);

	public ModelAndView getTransfer(HttpSession session, ModelMap model);

	public ModelAndView postTransfer(HttpSession session, TransactionInput transferInput, ModelMap model);

	public ModelAndView postWithdraw(HttpSession session, AccountSummary accountInput, ModelMap model);

	public ModelAndView getWithdraw(HttpSession session, ModelMap model);
}
