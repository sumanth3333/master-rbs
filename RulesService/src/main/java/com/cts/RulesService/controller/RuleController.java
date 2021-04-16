package com.cts.RulesService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.RulesService.model.ServiceChargeResponse;
import com.cts.RulesService.service.RuleService;

@RestController
public class RuleController {

	@Autowired
	public RuleService ruleService;

	@GetMapping("/evaluateMinBal/{bal}")
	public boolean evaluate(@RequestHeader("Authorization") String token, @PathVariable("bal") double bal) {
		return ruleService.evaluate(token, bal);
	}

	@GetMapping("/getServiceCharges")
	public List<ServiceChargeResponse> getServiceCharges(@RequestHeader("Authorization") String token) {
		return ruleService.serviceCharges(token);
	}

}
