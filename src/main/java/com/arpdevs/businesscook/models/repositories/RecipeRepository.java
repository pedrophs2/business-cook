package com.arpdevs.businesscook.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.arpdevs.businesscook.models.entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>{

}
