package com.arpdevs.businesscook.models.entities;

import java.util.HashMap;
import java.util.List;

public class Recipes {
	
	private Integer id;
	private String name;
	private List<Product> products;
	private HashMap<Product, Double> values;
	private Double cost;
	
	public Recipes() {}
	

}
