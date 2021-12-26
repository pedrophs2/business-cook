package com.arpdevs.businesscook.services;

import java.util.Optional;

import com.arpdevs.businesscook.exceptions.BadRequestException;
import com.arpdevs.businesscook.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.helpers.JwtHelper;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.models.repositories.UserRepository;
import com.arpdevs.businesscook.validators.auth.LoginValidator;
import com.arpdevs.businesscook.validators.auth.SignUpValidator;

@Service
public class AuthService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	JwtHelper jwtHelper;
	
	@Autowired
	private AuthenticationManager authManager;

	public User login(User user) throws ValidationException, Exception {
		LoginValidator validator = new LoginValidator();
		validator.validate(user);

		User loggedUser = repository.findByEmailContaining(user.getEmail());

		if (loggedUser == null)
			throw new BadRequestException("Usuário e/ou senha incorretos");

		if (!user.getPassword().equals(loggedUser.getPassword()))
			throw new BadRequestException("Usuário e/ou senha incorretos");
		
		loggedUser.setToken(this.authenticate(user));

		return loggedUser;
	}

	public User signUp(User user) throws ValidationException, Exception {
		SignUpValidator validator = new SignUpValidator();
		validator.validate(user);

		User validation = repository.findByEmailContaining(user.getEmail());

		if (validation != null)
			throw new ValidationException("Usuário já cadastrado");

		repository.save(user);
		user.setToken(this.authenticate(user));

		return user;
	}
	
	private String authenticate(User user) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
			throw new Exception("Usuário ou senha inválidos");
		}
		
		String token = jwtHelper.generateToken(user.getEmail());
		System.out.println(token);
		return token;
	}

}
