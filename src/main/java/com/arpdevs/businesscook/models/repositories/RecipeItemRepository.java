package com.arpdevs.businesscook.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arpdevs.businesscook.models.entities.RecipeItem;

public interface RecipeItemRepository extends CrudRepository<RecipeItem, Integer> {
	
	public List<RecipeItem> findByRecipeId(Integer id);

}
