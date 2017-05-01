package com.saisurya.poc.model;

import lombok.Data;

@Data
public class ChargeRequest {
	
	public enum Currency{
		INR,USD
	}
	
	private String description;
	
	private String amount;
	
	private Currency currency;
	
	private String stripeEmail;
	
	private String stripeToken;

}
