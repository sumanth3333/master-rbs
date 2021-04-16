package com.pod.BankingPortal.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.pod.BankingPortal.feign.AccountFeign;
import com.pod.BankingPortal.feign.AuthFeign;
import com.pod.BankingPortal.feign.CustomerFeign;
import com.pod.BankingPortal.feign.TransactionFeign;
import com.pod.BankingPortal.model.Account;
import com.pod.BankingPortal.model.AccountSummary;
import com.pod.BankingPortal.model.Customer;
import com.pod.BankingPortal.model.Transaction;
import com.pod.BankingPortal.model.TransactionInput;
import com.pod.BankingPortal.service.interfaces.TransactionServiceInterface;

@Service
public class TransactionService implements TransactionServiceInterface {

	@Autowired
	CustomerFeign customerFeign;

	@Autowired
	AccountFeign accountFeign;

	@Autowired
	AuthFeign authFeign;

	@Autowired
	TransactionFeign transactionFeign;

	@Override
	public ModelAndView postTransactionsList(HttpSession session, Model model, long accountId) {
		String token = (String) session.getAttribute("token");

		Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
		List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
		System.out.println(custAccs);
		model.addAttribute("accounts", custAccs);

		List<Transaction> l = transactionFeign.getTransactionsByAccId(token, accountId);
		model.addAttribute("transactions", l);
		return new ModelAndView("Transaction_Details");
	}

	@Override
	public ModelAndView getTransactionsList(HttpSession session, Model model) {
		if (session.getAttribute("token") != null) {
			String token = (String) session.getAttribute("token");
			Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
			List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
			System.out.println(custAccs);
			model.addAttribute("accounts", custAccs);
			System.out.println(cust);
			return new ModelAndView("Transaction_Details");
		} else
			return new ModelAndView("redirect:/login");
	}

	@Override
	public ModelAndView postDeposit(HttpSession session, AccountSummary accountInput, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("employeeLogin");
		} else {

			String token = (String) session.getAttribute("token");
			boolean depositSuccess = transactionFeign.makeDeposit(token, accountInput);
			if (depositSuccess) {
				model.addAttribute("deposit", "Deposit done successfully");
				return new ModelAndView("Deposit_amt", model);
			}

			else {

				model.addAttribute("deposit", "Invalid account details");
				return new ModelAndView("Deposit_amt", model);

			}

		}
	}

	@Override
	public ModelAndView getDeposit(HttpSession session, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("employeeLogin");
		}

		else {

			model.addAttribute("account", new AccountSummary());
			return new ModelAndView("Deposit_amt");
		}
	}

	@Override
	public ModelAndView getTransfer(HttpSession session, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("customerLogin");
		} else {
			model.addAttribute("transferinput", new TransactionInput());
			String token = (String) session.getAttribute("token");
			Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
			System.out.println((int) session.getAttribute("userId"));
			System.out.println(cust);
			List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
			System.out.println(custAccs);
			model.addAttribute("accounts", custAccs);
			return new ModelAndView("Transfer_amt");
		}
	}

	@Override
	public ModelAndView postTransfer(HttpSession session, TransactionInput transferInput, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("customerLogin");
		} else {

			String token = (String) session.getAttribute("token");
			Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
			System.out.println((int) session.getAttribute("userId"));
			System.out.println(cust);
			List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
			System.out.println(custAccs);
			model.addAttribute("accounts", custAccs);

			System.out.println(transferInput);
			boolean transferSuccess = transactionFeign.makeTransfer(token, transferInput);
			if (transferSuccess) {
				model.addAttribute("done", "Transfer done successfully");
				return new ModelAndView("Transfer_amt", model);
			}

			else {

				model.addAttribute("done", "Invalid account details or Minimum balance doesn't exist");
				return new ModelAndView("Transfer_amt", model);

			}

		}
	}

	@Override
	public ModelAndView postWithdraw(HttpSession session, AccountSummary accountInput, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("customerLogin");
		} else {

			String token = (String) session.getAttribute("token");
			Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
			System.out.println((int) session.getAttribute("userId"));
			System.out.println(cust);
			List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
			System.out.println(custAccs);
			model.addAttribute("accounts", custAccs);

			boolean withdrawSuccess = transactionFeign.makeWithdraw(token, accountInput);
			if (withdrawSuccess) {
				model.addAttribute("withdraw", "Withdraw done successfully");
				return new ModelAndView("withdraw", model);
			}

			else {
				model.addAttribute("withdraw", "Invalid account details or Minimum balance doesn't exist");
				return new ModelAndView("withdraw", model);
			}

		}
	}

	@Override
	public ModelAndView getWithdraw(HttpSession session, ModelMap model) {
		if (session.getAttribute("token") == null) {
			return new ModelAndView("customerLogin");
		} else {
			model.addAttribute("account", new AccountSummary());
			String token = (String) session.getAttribute("token");
			Customer cust = customerFeign.getDetails(token, (int) session.getAttribute("userId"));
			System.out.println((int) session.getAttribute("userId"));
			System.out.println(cust);
			List<Account> custAccs = accountFeign.getCustomerAccounts(token, cust.getCustomerId());
			System.out.println(custAccs);
			model.addAttribute("accounts", custAccs);

			return new ModelAndView("withdraw");
		}
	}
}
