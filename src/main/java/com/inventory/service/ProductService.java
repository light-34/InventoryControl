package com.inventory.service;

import java.util.List;
import java.util.Set;

import com.inventory.dto.ProductDetails;
import com.inventory.entity.Detail;
import com.inventory.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product findAProduct(long id);
	
	public Product saveProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(long id);
	
	public Set<String> categorySelect();
	
	public Detail saveDetail(Detail detail);
	
	public Detail findDetail(long id);
	
	public List<ProductDetails> findProductDetails(long id);
	

}
