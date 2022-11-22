package com.inventory.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.entity.Product;
import com.inventory.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public String getAllProducts(Model model) {
		List<Product> prodList = service.getAllProducts();
		model.addAttribute("listProducts", prodList);
		
		return "all-products";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("prod", new Product());
		return "add-product";
	}
	
	@PostMapping("/create")
	public String createProduct(@Valid @ModelAttribute("prod") Product prod,  BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "add-product";
		} else {
			service.saveProduct(prod);	
			return "redirect:all";
		}
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam(name = "id") long id, Model model) {
		Product product = service.findAProduct(id);
		model.addAttribute("prod", product);
		return "edit-product";
	}
	
	@PostMapping("/update")
	public String updateProductMethod(@Valid @ModelAttribute("prod") Product prod, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit-product";
		} else {
			service.updateProduct(prod);
			return "redirect:all";
		}
	}
	
	@GetMapping("/delete")
	public String deleteTheProduct(@RequestParam("id") long id, Model model) {
		service.deleteProduct(id);
		String message = "Product with id : " +id + " has been deleted"; 
		model.addAttribute("delete", message);
		return "redirect:all";
	}
	

}
