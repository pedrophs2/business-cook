package com.arpdevs.businesscook.validators.auth;

import java.util.Optional;

import com.arpdevs.businesscook.exceptions.ValidationException;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.validators.Validator;


public class LoginValidator extends Validator<User> {
	
	public void validateUser() throws ValidationException {
		if(object == null)
			throw new ValidationException("Preencha todos os dados para efetuar login");
	}
	
	public void validateEmail() throws ValidationException{
		if(object.getEmail() == null || object.getEmail().trim().equals(""))
			throw new ValidationException("Email deve ser preenchido");
	}
	
	public void validatePassword() throws ValidationException{
		if(object.getPassword() == null || object.getPassword().trim().equals(""))
			throw new ValidationException("Senha deve ser preenchida");
	}

}
