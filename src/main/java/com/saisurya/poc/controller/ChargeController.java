package com.saisurya.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.saisurya.poc.model.ChargeRequest;
import com.saisurya.poc.model.ChargeRequest.Currency;
import com.saisurya.poc.service.PaymentService;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class ChargeController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping(path = "/charge")
	public String chargeAmount(ChargeRequest chargeRequest, Model model) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException, APIException {
		chargeRequest.setDescription("Sample Charge");
		chargeRequest.setCurrency(Currency.INR);
		Charge charge = paymentService.charge(chargeRequest);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		model.addAttribute("chargeId", charge.getId());
		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException stripeException) {
		model.addAttribute("error", stripeException.getMessage());
		return "result";
	}
}
