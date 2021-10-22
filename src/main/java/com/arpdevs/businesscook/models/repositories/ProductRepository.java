package com.arpdevs.businesscook.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.arpdevs.businesscook.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
