package com.arpdevs.businesscook.controllers;

import com.arpdevs.businesscook.builders.ResponseBuilder;
import com.arpdevs.businesscook.exceptions.BadRequestException;
import com.arpdevs.businesscook.exceptions.ValidationException;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@CrossOrigin
@Api(value = "Products", tags = {"Products"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Returns a list of products")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Products found", response = Product.class, responseContainer = "List"),
			@ApiResponse(code = 204, message = "No product found")
	})
	public ResponseEntity<?> getAll() {
		try {
			Iterable<Product> products = productService.getAll();
			return new ResponseBuilder<Iterable<Product>>(products).ok();
		} catch(BadRequestException bre) {
			return new ResponseBuilder().badRequest(bre.getMessage());
		} catch(Exception ex) {
			return new ResponseBuilder().internalServerError();
		}
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Returns a product")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Product found", response = Product.class),
			@ApiResponse(code = 204, message = "No product found")
	})
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		try {
			Product product = productService.getById(id);
			return new ResponseBuilder<Product>(product).ok();
		} catch(BadRequestException bre) {
			return new ResponseBuilder().badRequest(bre.getMessage());
		} catch(Exception ex) {
			return new ResponseBuilder().internalServerError();
		}
	}
	
	@PostMapping(produces = "application/json")
	@ApiOperation(value = "Create a product")
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Product created", response = Product.class),
	})
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		try {
			productService.createProduct(product);
			return new ResponseBuilder<Product>(product).created();
		} catch(BadRequestException bre) {
			return new ResponseBuilder().badRequest(bre.getMessage());
		} catch(ValidationException ve) {
			return new ResponseBuilder().badRequest(ve.getMessage());
		} catch(Exception ex) {
			return new ResponseBuilder().internalServerError();
		}
	}
	
	@PutMapping(produces = "application/json")
	@ApiOperation(value = "Update a product")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Product updated", response = Product.class),
	})
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		try {
			productService.updateProduct(product);
			return new ResponseBuilder<Product>(product).ok();
		} catch(BadRequestException bre) {
			return new ResponseBuilder().badRequest(bre.getMessage());
		} catch(ValidationException ve) {
			return new ResponseBuilder().badRequest(ve.getMessage());
		} catch(Exception ex) {
			return new ResponseBuilder().internalServerError();
		}
	}

}
