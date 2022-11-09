package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.entity.Product;

@Controller
public class HomeController {
	
	@RequestMapping({"/", "/home"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("prod", new Product());
		return "add-product";
	}
	
}
