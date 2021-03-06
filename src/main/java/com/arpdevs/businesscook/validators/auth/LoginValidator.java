package com.arpdevs.businesscook.validators.auth;

import java.util.Optional;

import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.validators.Validator;


public class LoginValidator extends Validator<User> {
	
	public Optional<String> validateUser() {
		if(object == null)
			return Optional.of("Preencha todos os dados para efetuar login");
		
		return Optional.empty();
	}
	
	public Optional<String> validateEmail() {
		if(object.getEmail() == null || object.getEmail().trim().equals(""))
			return Optional.of("Email deve ser preenchido");
		
		return Optional.empty();
	}
	
	public Optional<String> validatePassword() {
		if(object.getPassword() == null || object.getPassword().trim().equals(""))
			return Optional.of("Senha deve ser preenchida");
		
		return Optional.empty();
	}

}
