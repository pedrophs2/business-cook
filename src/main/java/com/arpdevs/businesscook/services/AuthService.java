package com.arpdevs.businesscook.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.User;
import com.arpdevs.businesscook.models.repositories.UserRepository;
import com.arpdevs.businesscook.validators.LoginValidator;
import com.arpdevs.businesscook.validators.SignUpValidator;

public class AuthService {
	
	@Autowired
	UserRepository repository;
	
	public ResponseHandler<User> login(User user) {
		LoginValidator validator = new LoginValidator();
		Optional<String> errors = validator.validate(user);
		
		if(errors.isPresent())
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, errors.get(), null);
		
		User loggedUser = repository.findByEmailContaining(user.getEmail());
		
		if(loggedUser == null)
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, "Usuário/Senha Incorretos");
			
		if(!user.getPassword().equals(loggedUser.getPassword()))
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, "Usuário/Senha Incorretos");
		
		return new ResponseHandler<User>(HttpStatus.OK, "Login efetuado com sucesso !", loggedUser);
	}
	
	public ResponseHandler<User> signUp(User user) {
		SignUpValidator validator = new SignUpValidator();
		Optional<String> errors = validator.validate(user);
		
		if(errors.isPresent())
			return new ResponseHandler<User>(HttpStatus.BAD_REQUEST, errors.get());
		
		repository.save(user);
		
		return new ResponseHandler<User>(HttpStatus.CREATED, "Usuário cadastrado com sucesso !", user);
	}

}
