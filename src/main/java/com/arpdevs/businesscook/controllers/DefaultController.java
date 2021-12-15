package com.arpdevs.businesscook.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DefaultController {
	
	@GetMapping
	public String defaultMessage() {
		return "This is a RESTful API"; 
	}
	
	@GetMapping("/error")
	public String errorMessage() {
		return "There has been an error, please send a message to our support";
	}
	
	@GetMapping("/docs")
	public String swaggerDocs() {
		return "Hello World !";
	}

}
