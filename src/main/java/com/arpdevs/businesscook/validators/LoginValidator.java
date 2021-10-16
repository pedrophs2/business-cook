package com.arpdevs.businesscook.validators;

import java.util.Optional;

import com.arpdevs.businesscook.models.entities.User;


public class LoginValidator extends Validator<User> {
	
	public Optional<String> validateEmail() {
		if(object.getEmail() == null || object.getEmail().trim().equals(""))
			return Optional.of("Email deve ser preenchido");
		
		return Optional.empty();
	}
	
	public Optional<String> validatePassword() {
		if(object.getPassword() == null || object.getPassword().trim().equals(""))
			return Optional.of("Email deve ser preenchido");
		
		return Optional.empty();
	}

}
