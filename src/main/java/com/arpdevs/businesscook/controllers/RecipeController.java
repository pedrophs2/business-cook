package com.arpdevs.businesscook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.Recipe;
import com.arpdevs.businesscook.models.entities.RecipeItem;
import com.arpdevs.businesscook.services.RecipeItemService;
import com.arpdevs.businesscook.services.RecipeService;

@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	RecipeItemService itemsService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		ResponseHandler<Iterable<Recipe>> response = recipeService.getAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		ResponseHandler<Recipe> response = recipeService.getById(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
		ResponseHandler<Recipe> response = recipeService.saveRecipe(recipe);
		itemsService.createFromRecipe(recipe);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PutMapping
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe) {
		ResponseHandler<Recipe> response = recipeService.saveRecipe(recipe);
		itemsService.updateFromRecipe(recipe);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteRecipe(@RequestBody Recipe recipe) {
		itemsService.deleteFromRecipe(recipe);
		ResponseHandler<Recipe> response = recipeService.deleteRecipe(recipe);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
