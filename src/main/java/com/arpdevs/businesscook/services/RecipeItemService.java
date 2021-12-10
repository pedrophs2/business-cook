package com.arpdevs.businesscook.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Recipe;
import com.arpdevs.businesscook.models.entities.RecipeItem;
import com.arpdevs.businesscook.models.repositories.RecipeItemRepository;

public class RecipeItemService {
	
	@Autowired
	RecipeItemRepository repository;
	
	public ResponseHandler<Iterable<RecipeItem>> getAll() {
		Iterable<RecipeItem> items = repository.findAll();
		
		if(((Collection<?>)items).size() <= 0)
			return new ResponseHandler<Iterable<RecipeItem>>(HttpStatus.NO_CONTENT, "Nenhum item encontrado");
		
		return new ResponseHandler<Iterable<RecipeItem>>(HttpStatus.OK, "Itens encontrados", items);
	}
	
	public ResponseHandler<RecipeItem> getById(int id) {
		Optional<RecipeItem> recipeItem = repository.findById(id);
		
		if(!recipeItem.isPresent())
			return new ResponseHandler<RecipeItem>(HttpStatus.NO_CONTENT, "Nenhum item encontrado");
		
		return new ResponseHandler<RecipeItem>(HttpStatus.OK, "Item encontrado", recipeItem.get());
	}
	
	public ResponseHandler<List<RecipeItem>> findByRecipeId(int recipeId) {
		List<RecipeItem> items = repository.findByRecipeId(recipeId);
		
		if(items.size() <= 0)
			return new ResponseHandler<List<RecipeItem>>(HttpStatus.NO_CONTENT, "Nenhum item encontrado para essa receita");
		
		return new ResponseHandler<List<RecipeItem>>(HttpStatus.OK, "Itens encontrados", items);
	}
	
	public ResponseHandler<RecipeItem> saveItem(RecipeItem recipeItem) {
		repository.save(recipeItem);
		return new ResponseHandler<RecipeItem>(HttpStatus.CREATED, "Item de receita criado com sucesso !", recipeItem);
	}
	
	public ResponseHandler<List<RecipeItem>> saveItems(List<RecipeItem> items) {
		repository.saveAll(items);
		return new ResponseHandler<List<RecipeItem>>(HttpStatus.CREATED, "Items de receita criados com Sucesso !", items);
	}
	
	public ResponseHandler<List<RecipeItem>> createFromRecipe(Recipe recipe) {
		recipe.getItems().forEach(item -> {
			item.setRecipe(recipe);
		});
		
		repository.saveAll(recipe.getItems());
		
		return new ResponseHandler<List<RecipeItem>>(HttpStatus.CREATED, "Items criados e cadastrados na receita com sucesso !", recipe.getItems());
	}
	
	public ResponseHandler<List<RecipeItem>> updateFromRecipe(Recipe recipe) {
		List<RecipeItem> current = repository.findByRecipeId(recipe.getId());
		List<Integer> currentIn = new ArrayList<>();
		List<Integer> newOnes = new ArrayList<>();
		
		current.forEach(item -> {
			currentIn.add(item.getId());
		});
		
		recipe.getItems().forEach(item -> {
			item.setRecipe(recipe);
			newOnes.add(item.getId());
		});
		
		currentIn.forEach(id -> {
			if(newOnes.indexOf(id) < 0)
				repository.delete(current.get(currentIn.indexOf(id)));
		});
		
		repository.saveAll(recipe.getItems());
		
		return new ResponseHandler<List<RecipeItem>>(HttpStatus.CREATED, "Itens salvos com sucesso !", recipe.getItems());
	}
	
	public ResponseHandler<List<RecipeItem>> deleteFromRecipe(Recipe recipe) {
		List<RecipeItem> items = repository.findByRecipeId(recipe.getId());
		repository.deleteAll(items);
		
		return new ResponseHandler<List<RecipeItem>>(HttpStatus.OK, "Itens deletados com sucesso", recipe.getItems());
	}

}
