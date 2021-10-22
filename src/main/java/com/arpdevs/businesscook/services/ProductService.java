package com.arpdevs.businesscook.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Product;
import com.arpdevs.businesscook.models.repositories.ProductRepository;

public class ProductService {

	@Autowired
	ProductRepository repository;

	public ResponseHandler<Product> createUser(Product product) {
		// Create a Validator Interface
		// Create validator instance
		// Validate
		// Insert a Product
		return null;
	}

}
