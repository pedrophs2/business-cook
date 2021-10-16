package com.arpdevs.businesscook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.services.AuthService;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("rawtypes")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody User user) {	
		ResponseHandler<User> response = authService.login(user);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/signup")
	public ResponseEntity signUp(@RequestBody User user) {
		ResponseHandler<User> response = authService.signUp(user);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
