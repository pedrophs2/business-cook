package com.arpdevs.businesscook;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import com.arpdevs.businesscook.services.AuthService;
import com.arpdevs.businesscook.services.ProductService;
import com.arpdevs.businesscook.services.RecipeItemService;
import com.arpdevs.businesscook.services.RecipeService;

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
