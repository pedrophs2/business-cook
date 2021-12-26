package com.arpdevs.businesscook.validators.auth;

import java.util.Optional;

import com.arpdevs.businesscook.exceptions.ValidationException;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.validators.Validator;

public class SignUpValidator extends Validator<User> {

	public void validateName() throws ValidationException {
		if (object.getName() == null || object.getName().trim().equals(""))
			throw new ValidationException("Nome deve ser preenchido");

	}

	public void validateEmail() throws ValidationException {
		if (object.getEmail() == null || object.getEmail().trim().equals(""))
			throw new ValidationException("Email deve ser preenchido");
	}

	public void validatePassword() throws ValidationException {
		if (object.getPassword() == null || object.getPassword().trim().equals(""))
			throw new ValidationException("Email deve ser preenchido");
	}

}
