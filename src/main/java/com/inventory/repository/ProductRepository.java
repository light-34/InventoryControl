package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findById(int id);

}
