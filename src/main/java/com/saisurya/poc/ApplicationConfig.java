package com.saisurya.poc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;

import lombok.Getter;

@Component
public class ApplicationConfig {

	@Value("${PRIVATE.KEY}")
	@Getter
	private String privateKey;

	@Value("${PUBLIC.KEY}")
	@Getter
	private String publicKey;
	
	@PostConstruct
	public void init(){
		Stripe.apiKey = this.privateKey;
	}
}
