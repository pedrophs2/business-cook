package com.arpdevs.businesscook.validators;

import java.util.Optional;

import com.arpdevs.businesscook.models.entities.Product;

public class CreateProductValidator extends Validator<Product> {

	public Optional<String> validateProductAttributes() {
		if (object.getName() == null || object.getName().trim().equals(""))
			return Optional.of("É necessário um nome para o produtor");

		if (object.getPrice() == null)
			return Optional.of("É necessário um valor para o produto");

		if (object.getAmount() == null)
			return Optional.of("É necessário a quantidade da embalagem do produto");

		return Optional.empty();

	}

}
