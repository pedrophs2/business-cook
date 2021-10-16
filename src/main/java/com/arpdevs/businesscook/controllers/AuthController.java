package com.arpdevs.businesscook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.models.repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		User loggedUser = repository.findByEmailContaining(user.getEmail());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedUser);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		repository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

}
