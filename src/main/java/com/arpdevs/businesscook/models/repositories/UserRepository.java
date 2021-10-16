package com.arpdevs.businesscook.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.arpdevs.businesscook.models.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByEmailContaining(String email);
	
}
