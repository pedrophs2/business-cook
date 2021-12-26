package com.arpdevs.businesscook.services;

import java.util.Optional;

import com.arpdevs.businesscook.exceptions.BadRequestException;
import com.arpdevs.businesscook.exceptions.ValidationException;
import com.arpdevs.businesscook.helpers.IterableHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Product;
import com.arpdevs.businesscook.models.repositories.ProductRepository;
import com.arpdevs.businesscook.validators.product.CreateProductValidator;
import com.arpdevs.businesscook.validators.product.UpdateProductValidator;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Iterable<Product> getAll() throws BadRequestException, Exception {
		Iterable<Product> products = repository.findAll();

		if(new IterableHelper<Product>(products).isEmpty())
			throw new BadRequestException("Nenhum produto encontrado");

		return repository.findAll();
	}
	
	public Product getById(int id) throws BadRequestException, Exception {
		Optional<Product> product = repository.findById(id);
		
		if(product.isPresent())
			return product.get();
		
		throw new BadRequestException("Nenhum produto encontrado");
	}

	public Product createProduct(Product product) throws ValidationException, BadRequestException, Exception {
		CreateProductValidator validator = new CreateProductValidator();
		validator.validate(product);
		
		repository.save(product);
		return product;
	}
	
	public Product updateProduct(Product product) throws ValidationException, BadRequestException, Exception {
		UpdateProductValidator validator = new UpdateProductValidator();
		validator.validate(product);
		
		repository.save(product);
		return product;
	}

}
