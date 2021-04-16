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

import com.pod.BankingPortal.model.AccountSummary;
import com.pod.BankingPortal.model.TransactionInput;
import com.pod.BankingPortal.service.interfaces.TransactionServiceInterface;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionServiceInterface transactionService;

	@GetMapping("/transactions")
	public ModelAndView getTransactions(HttpSession session, Model model) {
		return transactionService.getTransactionsList(session, model);
	}

	@PostMapping("/getTransactions")
	public ModelAndView getTransactionsList(HttpSession session, Model model, @RequestParam long accountId) {
		return transactionService.postTransactionsList(session, model, accountId);
	}

	@GetMapping("/withdraw")
	public ModelAndView withdrawPage(HttpSession session, ModelMap model) {
		return transactionService.getWithdraw(session, model);

	}

	@PostMapping("/checkwithdraw")
	public ModelAndView withdraw(HttpSession session, @ModelAttribute("account") AccountSummary accountInput,
			ModelMap model) {
		return transactionService.postWithdraw(session, accountInput, model);
	}

	@PostMapping("/checktransfer")
	public ModelAndView transfercheck(HttpSession session,
			@ModelAttribute("transferinput") TransactionInput transferInput, ModelMap model) {
		return transactionService.postTransfer(session, transferInput, model);

	}

	@GetMapping("/transfer")
	public ModelAndView transferPage(HttpSession session, ModelMap model) {
		return transactionService.getTransfer(session, model);

	}

	@GetMapping("/deposit")
	public ModelAndView depositPage(HttpSession session, ModelMap model) {
		return transactionService.getDeposit(session, model);

	}

	@PostMapping("/checkdeposit")
	public ModelAndView deposit(HttpSession session, @ModelAttribute("account") AccountSummary accountInput,
			ModelMap model) {
		return transactionService.postDeposit(session, accountInput, model);

	}
	
}
