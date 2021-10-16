package com.arpdevs.businesscook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@GetMapping
	public String defaultMessage() {
		return "This is a RESTful API"; 
	}
	
	@GetMapping("/error")
	public String errorMessage() {
		return "There has been an error, please send a message to our support";
	}

}
