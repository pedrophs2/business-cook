package com.arpdevs.businesscook.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Recipe;
import com.arpdevs.businesscook.models.repositories.RecipeRepository;

public class RecipeService {
	
	@Autowired
	RecipeRepository repository;
	
	public ResponseHandler<Iterable<Recipe>> getAll() {
		Iterable<Recipe> recipes = repository.findAll();
		
		if(((Collection<?>)recipes).size() <= 0)
			return new ResponseHandler<Iterable<Recipe>>(HttpStatus.NO_CONTENT, "Nenhuma receita encontrada");
		
		return new ResponseHandler<Iterable<Recipe>>(HttpStatus.OK, "Receitas Encontradas", repository.findAll());
	}
	
	public ResponseHandler<Recipe> getById(int id) {
		Optional<Recipe> recipe = repository.findById(id);
		
		if(recipe.isPresent())
			return new ResponseHandler<Recipe>(HttpStatus.OK, "Receita Encontrada", recipe.get());
		
		return new ResponseHandler<Recipe>(HttpStatus.NO_CONTENT, "Nenhuma receita encontrada");
	}
	
	public ResponseHandler<Recipe> saveRecipe(Recipe recipe) {
		repository.save(recipe);
		return new ResponseHandler<Recipe>(HttpStatus.CREATED, "Receita salva com sucesso", recipe);
	}
	
	public ResponseHandler<Recipe> deleteRecipe(Recipe recipe) {
		repository.delete(recipe);
		return new ResponseHandler<Recipe>(HttpStatus.OK, "Receita deletada com sucesso", recipe);
	}

}
