package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.dto.ProductDetails;
import com.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findById(long id);


	
	/*
	 * @Query("SELECT new com.inventory.dto.ProductDetails(p.id, p.name, p.category, p.price, p.image, d.brand, d.asin, d.ean, d.ingredients, d.certificates)"
	 * + "FROM Product p JOIN Detail d ON p.id = :id") ProductDetails
	 * findAProduct(long id);
	 */
	
	@Query("SELECT new com.inventory.dto.ProductDetails(p.id, p.name, p.category, p.price, d.brand, d.asin, d.ean, d.ingredients, d.certificates)"
			  + "FROM Product p JOIN p.details d WHERE p.id = :id")
	List<ProductDetails> findByIdDetails(long id);
	
	//List<ProductDetails> findAllProduct(long id);
	
	

}
