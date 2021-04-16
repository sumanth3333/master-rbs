package com.cts.RulesService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.RulesService.feign.AccountFeign;
import com.cts.RulesService.model.Account;
import com.cts.RulesService.model.ServiceChargeResponse;

@Service
public class RuleService {

	public static final int MINIMUM_BALANCE = 1000;
	
	@Autowired
	private AccountFeign accountFeign;
	
	public boolean evaluate(String token,double bal) {
		// if balance should higher than minimum balance
		
		if (bal >= MINIMUM_BALANCE)
			return true;
		else
			return false;
	}

	public List<ServiceChargeResponse> serviceCharges(String token) {
		List<ServiceChargeResponse> responseList = new ArrayList<ServiceChargeResponse>();

		List<Account> accounts = accountFeign.getAllAccounts(token);
		ServiceChargeResponse response= new ServiceChargeResponse();
		for(Account each : accounts) {
			
			double bal = each.getCurrentBalance();
		if (bal < 1000) {
			// if balance is lesser then minimum balance 10% detected from minimum balance
			double deduction = bal / 10;
			response.setMessage("Your Balance is lesser than the minimum balance so, RS." + deduction
					+ " is detected from your account");
			response.setAccBalance(bal - deduction);
			each.setCurrentBalance(bal - deduction);
			accountFeign.saveAcc(token, each);
		} else {
			// if minimum balance is maintained no detection occurred
			response.setMessage("No Detection");
			response.setAccBalance(bal);
		}
		responseList.add(response);
		}
		return responseList;
	}

}
