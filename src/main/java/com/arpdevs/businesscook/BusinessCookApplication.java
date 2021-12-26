package com.arpdevs.businesscook;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusinessCookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessCookApplication.class, args);
	}
	
	@PostConstruct
    public void init(){
		System.out.println("TimeZone Changed");
		TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }

}
