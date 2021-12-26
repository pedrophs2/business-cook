package com.arpdevs.businesscook.validators;

import com.arpdevs.businesscook.exceptions.BadRequestException;
import com.arpdevs.businesscook.exceptions.ValidationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class Validator<E> {
	
	public E object;
	
	public void validate(E object) throws BadRequestException, ValidationException, Exception {
		this.object = object;
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().endsWith("validate"))
				continue;

			method.invoke(this);
		}

		return;
	}

}
