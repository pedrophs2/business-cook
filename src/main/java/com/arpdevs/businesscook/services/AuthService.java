package com.arpdevs.businesscook.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.helpers.JwtHelper;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.models.repositories.UserRepository;
import com.arpdevs.businesscook.validators.auth.LoginValidator;
import com.arpdevs.businesscook.validators.auth.SignUpValidator;

public class AuthService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	JwtHelper jwtHelper;
	
	@Autowired
	private AuthenticationManager authManager;

	public ResponseHandler<User> login(User user) throws Exception {
		LoginValidator validator = new LoginValidator();
		Optional<String> errors = validator.validate(user);

		if (errors.isPresent())
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, errors.get(), null);

		User loggedUser = repository.findByEmailContaining(user.getEmail());

		if (loggedUser == null)
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, "Usuário/Senha Incorretos");

		if (!user.getPassword().equals(loggedUser.getPassword()))
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, "Usuário/Senha Incorretos");
		
		loggedUser.setToken(this.authenticate(user));

		return new ResponseHandler<User>(HttpStatus.OK, "Login efetuado com sucesso !", loggedUser);
	}

	public ResponseHandler<User> signUp(User user) {
		SignUpValidator validator = new SignUpValidator();
		Optional<String> errors = validator.validate(user);

		if (errors.isPresent())
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, errors.get());

		User validation = repository.findByEmailContaining(user.getEmail());

		if (validation != null)
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");

		repository.save(user);

		return new ResponseHandler<User>(HttpStatus.CREATED, "Usuário cadastrado com sucesso !", user);
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
