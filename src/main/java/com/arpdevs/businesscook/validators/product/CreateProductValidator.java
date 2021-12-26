package com.arpdevs.businesscook.validators.product;

import java.util.Optional;

import com.arpdevs.businesscook.exceptions.ValidationException;
import com.arpdevs.businesscook.models.entities.Product;
import com.arpdevs.businesscook.validators.Validator;

public class CreateProductValidator extends Validator<Product> {

	public void validateName() throws ValidationException {
		if (object.getName() == null || object.getName().trim().equals(""))
			throw new ValidationException("É necessário um nome para o produtor");
	}

	public void validatePrice() throws ValidationException {
		if (object.getPrice() == null)
			throw new ValidationException("É necessário um valor para o produto");
	}

	public void validateAmount() throws ValidationException {
		if (object.getAmount() == null)
			throw new ValidationException("É necessário a quantidade da embalagem do produto");
	}
}
