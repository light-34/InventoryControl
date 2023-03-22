package com.inventory.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.inventory.dto.ProductDetails;
import com.inventory.entity.Detail;
import com.inventory.entity.Product;
import com.inventory.repository.DetailRepository;
import com.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository repository;
	
	private final DetailRepository detailRepository;
	
	public ProductServiceImpl(ProductRepository repository, DetailRepository detailRepository) {
		this.repository = repository;
		this.detailRepository = detailRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	public Product findAProduct(long id) {
		
		return repository.findById(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product upProduct = repository.findById(product.getId());
		upProduct.setName(product.getName());
		upProduct.setCategory(product.getCategory());
		upProduct.setPrice(product.getPrice());
		upProduct.setImage(product.getImage());
		repository.save(upProduct);
	}

	@Override
	public void deleteProduct(long id) {

		repository.deleteById(id);
		
	}

	@Override
	public Set<String> categorySelect() {
		String [] arrStrings = {
				"Beauty & Personal Care",
				"Health & Personal Care",
				"Toys & Games",
				"Grocery & Gourmet Food",
				"Home",
				"Baby",
				"Office Products",
				"Pet Supplies",
				"Sports & Outdoors",
				"Clothing & Accessories"
		};
		
		return Arrays.stream(arrStrings).collect(Collectors.toSet());
	}

	@Override
	public Detail saveDetail(Detail detail) {	
		return detailRepository.save(detail);
	}

	@Override
	public Detail findDetail(long id) {		
		return detailRepository.findById(id);
	}

	@Override
	public List<ProductDetails> findProductDetails(long id) {
		
		return repository.findByIdDetails(id);
		
	}

	@Override
	public boolean existsWithId(long id) {
		return repository.existsById(id);
	}


}
