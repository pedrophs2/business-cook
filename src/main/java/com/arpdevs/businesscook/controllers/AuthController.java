package com.arpdevs.businesscook.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.models.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return user;
	}

}
