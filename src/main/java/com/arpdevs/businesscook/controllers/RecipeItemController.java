package com.arpdevs.businesscook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.handlers.ResponseHandler;
import com.arpdevs.businesscook.models.entities.RecipeItem;
import com.arpdevs.businesscook.services.RecipeItemService;

@RestController
@RequestMapping("/recipe/item")
@CrossOrigin
public class RecipeItemController {
	
	@Autowired
	RecipeItemService recipeItemService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		ResponseHandler<Iterable<RecipeItem>> response = recipeItemService.getAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		ResponseHandler<RecipeItem> response = recipeItemService.getById(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/recipe/{id}")
	public ResponseEntity<?> getAllFromRecipeId(@PathVariable("id") int id) {
		ResponseHandler<List<RecipeItem>> response = recipeItemService.findByRecipeId(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
