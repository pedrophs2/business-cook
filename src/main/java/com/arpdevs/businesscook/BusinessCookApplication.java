package com.arpdevs.businesscook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import com.arpdevs.businesscook.services.AuthService;

@SpringBootApplication
public class BusinessCookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessCookApplication.class, args);
	}
	
	@Bean
	public AuthService getAuthService() {
		return new AuthService();
	}

}
