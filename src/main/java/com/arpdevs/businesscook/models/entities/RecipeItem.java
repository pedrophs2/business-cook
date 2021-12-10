package com.arpdevs.businesscook.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bck_recipe_item")
public class RecipeItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Product product;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
	
	private int amount;
	private Double price;
	
	public RecipeItem() {}

	public RecipeItem(Product product, Recipe recipe, int amount) {
		super();
		this.setProduct(product);
		this.setRecipe(recipe);
		this.setAmount(amount);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		System.out.println("Got Here");
		this.amount = amount;
		
		if(this.product != null) 
			this.setPrice((this.product.getPrice() / this.product.getAmount()) * this.amount);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
