package com.arpdevs.businesscook.services;

import java.util.Optional;

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
	
	public ResponseHandler<Iterable<Product>> getAll() {
		return new ResponseHandler<Iterable<Product>>(HttpStatus.OK, "Produtos encontrados", repository.findAll());
	}
	
	public ResponseHandler<Product> getById(int id) {
		Optional<Product> product = repository.findById(id);
		
		if(product.isPresent())
			return new ResponseHandler<Product>(HttpStatus.OK, "Produto Encontrado", product.get());
		
		return new ResponseHandler<Product>(HttpStatus.NO_CONTENT, "Nenhum produto encontrado");
	}

	public ResponseHandler<Product> createProduct(Product product) {
		CreateProductValidator validator = new CreateProductValidator();
		Optional<String> errors = validator.validate(product);
		
		if(errors.isPresent())
			return new ResponseHandler<Product>(HttpStatus.BAD_REQUEST, errors.get());
		
		repository.save(product);
		return new ResponseHandler<Product>(HttpStatus.CREATED, "Produto registrado com sucesso", product);
	}
	
	public ResponseHandler<Product> updateProduct(Product product) {
		UpdateProductValidator validator = new UpdateProductValidator();
		Optional<String> errors = validator.validate(product);
		
		if(errors.isPresent())
			return new ResponseHandler<Product>(HttpStatus.BAD_REQUEST, errors.get());
		
		repository.save(product);
		return new ResponseHandler<Product>(HttpStatus.CREATED, "Produto atualizado com sucesso", product);
	}

}
