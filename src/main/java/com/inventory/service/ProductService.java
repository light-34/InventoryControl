package com.inventory.service;

import java.util.List;

import com.inventory.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product findAProduct(int id);
	
	public void saveProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);

}