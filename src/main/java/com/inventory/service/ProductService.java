package com.inventory.service;

import java.util.List;
import java.util.Set;

import com.inventory.dto.ProductDetails;
import com.inventory.entity.Detail;
import com.inventory.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product findAProduct(long id);
	
	Product saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(long id);
	
	Set<String> categorySelect();
	
	Detail saveDetail(Detail detail);
	
	Detail findDetail(long id);
	
	List<ProductDetails> findProductDetails(long id);

	boolean existsWithId(long id);
	

}
