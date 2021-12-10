package com.arpdevs.businesscook.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bck_recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "recipe")
	private List<RecipeItem> items = new ArrayList<>();
	
	private Double total = 0.0;
	private Date creationDate;
	
	public Recipe() {
		this.creationDate = new Date();
	}	

	public Recipe(String name) {
		super();
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RecipeItem> getItems() {
		return items;
	}

	public void setItems(List<RecipeItem> items) {
		this.items = items;
		
		for(RecipeItem item: items)
			this.total += item.getPrice();
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
