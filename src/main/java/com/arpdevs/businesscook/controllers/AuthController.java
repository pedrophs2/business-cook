package com.arpdevs.businesscook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Recipe;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.services.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@Api(value = "Authentication", tags = {"Authentication"})
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@ApiOperation(value = "Authenticates a user and generates a JWT Token")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User authenticated", response = User.class),
			@ApiResponse(code = 204, message = "User not found")
	})
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> login(@RequestBody User user) {	
		try {
			ResponseHandler<User> response = authService.login(user);
			return ResponseEntity.status(response.getStatus()).body(response);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no processo de requisição");
		}
	}
	
	@ApiOperation(value = "Creates a user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "User created", response = User.class),
	})
	@PostMapping(value = "/signup", produces = "application/json")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		try {
			ResponseHandler<User> response = authService.signUp(user);
			return ResponseEntity.status(response.getStatus()).body(response);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no processo de requisição");
		}
	}

}
