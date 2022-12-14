package com.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return repository.findAll();
	}

	@Override
	public Product findAProduct(long id) {
		
		return repository.findById(id);
	}

	@Override
	public Product saveProduct(Product product) {
		product.setAsin(product.getAsin().toUpperCase());
		return repository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product upProduct = repository.findById(product.getId());
		upProduct.setAsin(product.getAsin());
		upProduct.setDate(product.getDate());
		upProduct.setManufacturer(product.getManufacturer());
		upProduct.setName(product.getName());	
		repository.save(upProduct);
	}

	@Override
	public void deleteProduct(long id) {
		repository.deleteById(id);
		
	}

}
