package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.entity.Detail;
import com.inventory.entity.Product;
import com.inventory.service.ProductService;

@RestController
@RequestMapping("/rest")
public class DetailRestController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/details/{id}")
	public Detail getDetailsOfProduct(@PathVariable long id) {
		
		Detail detail = service.findDetail(id);
		//Product product = service.findAProduct(detail.getProduct().getId());
		
		//This code set the product for the field of product in Detail entity
		//detail.setProduct(product);
		
		return detail;
		
	}
	
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getA/{id}")
	public Product getOneProducts(@PathVariable long id) {
		return service.findAProduct(id);
	}

}
