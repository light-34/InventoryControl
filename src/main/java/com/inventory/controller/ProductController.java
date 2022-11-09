package com.inventory.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.entity.Product;
import com.inventory.service.ProductService;

@Controller
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<Product> prodList = service.getAllProducts();
		model.addAttribute("listProducts", prodList);
		
		return "all-products";
	}
	
	@PostMapping("/prodCreate")
	public String createProduct(@Valid @ModelAttribute("prod") Product prod,  BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "add-product";
		} else {
			service.saveProduct(prod);	
			return "redirect:products";
		}

	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam(name = "id") int id, Model model) {
		Product product = service.findAProduct(id);
		
		model.addAttribute("prod", product);
		
		return "edit-product";
	}
	
	@PostMapping("/prodUpdate")
	public String updateProductMethod(@Valid @ModelAttribute("prod") Product prod, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit-product";
		} else {
			service.updateProduct(prod);
			return "redirect:products";
		}
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProductMethod(@RequestParam("id") int id, Model model) {
		service.deleteProduct(id);
		String message = "Product with id : " +id + " has been deleted"; 
		model.addAttribute("delete", message);
		return "redirect:products";
	}
	

}
