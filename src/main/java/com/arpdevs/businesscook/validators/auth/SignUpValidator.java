package com.arpdevs.businesscook.validators.auth;

import java.util.Optional;

import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.validators.Validator;

public class SignUpValidator extends Validator<User> {

	public Optional<String> validateName() {
		if (object.getName() == null || object.getName().trim().equals(""))
			return Optional.of("Nome deve ser preenchido");

		return Optional.empty();
	}

	public Optional<String> validateEmail() {
		if (object.getEmail() == null || object.getEmail().trim().equals(""))
			return Optional.of("Email deve ser preenchido");

		return Optional.empty();
	}

	public Optional<String> validatePassword() {
		if (object.getPassword() == null || object.getPassword().trim().equals(""))
			return Optional.of("Email deve ser preenchido");

		return Optional.empty();
	}

}
