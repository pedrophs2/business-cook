package com.arpdevs.businesscook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping
	public String login() {
		return "Hello World";
	}

}