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
import com.arpdevs.businesscook.models.entities.Recipe;
import com.arpdevs.businesscook.models.entities.RecipeItem;
import com.arpdevs.businesscook.services.RecipeItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/recipe/item")
@CrossOrigin
@Api(value = "Recipe Items", tags = {"Recipe Items"})
public class RecipeItemController {
	
	@Autowired
	RecipeItemService recipeItemService;
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Returns a list of recipe items")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recipe Items found", response = Recipe.class, responseContainer = "List"),
			@ApiResponse(code = 204, message = "No recipe items found")
	})
	public ResponseEntity<?> getAll() {
		ResponseHandler<Iterable<RecipeItem>> response = recipeItemService.getAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Returns a recipe item")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recipe Item found", response = Recipe.class, responseContainer = "List"),
			@ApiResponse(code = 204, message = "No recipe item found")
	})
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		ResponseHandler<RecipeItem> response = recipeItemService.getById(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping(value = "/recipe/{id}", produces = "application/json")
	@ApiOperation(value = "Returns a list of recipe items from a recipe")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recipe Items found", response = Recipe.class, responseContainer = "List"),
			@ApiResponse(code = 204, message = "No recipe items found")
	})
	public ResponseEntity<?> getAllFromRecipeId(@PathVariable("id") int id) {
		ResponseHandler<List<RecipeItem>> response = recipeItemService.findByRecipeId(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
