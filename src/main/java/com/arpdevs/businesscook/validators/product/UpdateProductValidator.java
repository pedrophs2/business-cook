package com.arpdevs.businesscook.validators.product;

import java.util.Optional;

import com.arpdevs.businesscook.models.entities.Product;
import com.arpdevs.businesscook.validators.Validator;

public class UpdateProductValidator extends Validator<Product> {

	public Optional<String> validateId() {
		
		if(object == null)
			return Optional.of("É necessário um produto válido");
		
		if(object.getId() == null || object.getId() <= 0)
			return Optional.of("É necessário um produto válido");
		
		if (object.getName() == null || object.getName().trim().equals(""))
			return Optional.of("É necessário um nome para o produtor");

		if (object.getPrice() == null)
			return Optional.of("É necessário um valor para o produto");

		if (object.getAmount() == null)
			return Optional.of("É necessário a quantidade da embalagem do produto");
		
		return Optional.empty();
	}
	
}
