package com.arpdevs.businesscook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Product;
import com.arpdevs.businesscook.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
@SuppressWarnings("rawtypes")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity getAll() {
		ResponseHandler<Iterable<Product>> response = productService.getAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") int id) {
		ResponseHandler<Product> response = productService.getById(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping
	public ResponseEntity createProduct(@RequestBody Product product) {
		ResponseHandler<Product> response = productService.createProduct(product);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PutMapping
	public ResponseEntity updateProduct(@RequestBody Product product) {
		ResponseHandler<Product> response = productService.updateProduct(product);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
