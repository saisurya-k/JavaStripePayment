package com.saisurya.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saisurya.poc.ApplicationConfig;
import com.saisurya.poc.model.ChargeRequest;

@Controller
public class CheckoutController {
	
	@Autowired
	ApplicationConfig applicationConfig;

	@RequestMapping("/checkout")
	public String checkout(Model checkoutModel){
		checkoutModel.addAttribute("Amount","500000");
		checkoutModel.addAttribute("PublicKey", applicationConfig.getPublicKey());
		checkoutModel.addAttribute("Currency", ChargeRequest.Currency.INR);
		return "checkout";
	}
	
 }
