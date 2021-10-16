package com.arpdevs.businesscook.validators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class Validator<E> {
	
	public E object;
	
	public Optional<String> validate(E object) {
		this.object = object;
		try {
			Method[] methods = this.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().endsWith("validate"))
					continue;
				
				@SuppressWarnings("unchecked")
				Optional<String> op = ((Optional<String>) method.invoke(this));
				if(op.isPresent()) {
					return op;
				}
			}

			return Optional.empty();
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			ex.printStackTrace(System.out);
			return Optional.of(ex.getMessage());
		}
	}

}
