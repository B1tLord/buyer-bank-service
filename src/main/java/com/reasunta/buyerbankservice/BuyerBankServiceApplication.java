package com.reasunta.buyerbankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class BuyerBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerBankServiceApplication.class, args);
	}

}
