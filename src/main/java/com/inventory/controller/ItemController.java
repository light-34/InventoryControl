package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.inventory.entity.Item;
import com.inventory.service.ItemService;
import com.inventory.service.ProductService;
import com.inventory.service.PurchaseService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	private ItemService service;
	
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public String getAllItems(Model model) {
		List<Item> itemList = service.getAllItems();
		model.addAttribute("listItems", itemList);
		
		return "item/all-items";
	}
	
	@GetMapping("/add")
	public String addItem(Model model) {
		model.addAttribute("puritem", new Item());
		model.addAttribute("listProduct", productService.getAllProducts());
		model.addAttribute("listPurchases", purchaseService.getAllPurchases());
		model.addAttribute("states", service.getStates());
		return "item/add-item";
	}
	
	@PostMapping("/create")
	public String createItem(@Valid @ModelAttribute("puritem") Item item, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:add";
		} else {
			
			service.saveItem(item);
			return "redirect:all";
		}
	}
	
	@GetMapping("/updateItem")
	public String updateItem(@RequestParam(name = "id") long id, Model model) {
		Item item = service.findAnItem(id);
		model.addAttribute("theItem", item);
		return "item/edit-item";
	}
	
	@PostMapping("/update")
	public String updateItemMethod(@Valid @ModelAttribute("theItem") Item item, BindingResult result) {
		if (result.hasErrors()) {
			return "item/edit-item";
		} else {
			service.updateItem(item);
			return "redirect:all";
		}
	}
	
	@GetMapping("/delete")
	public String deleteProductMethod(@RequestParam(name = "id") long id, Model model) {
		service.deleteItem(id);
		String message = "Item with id : " +id + " has been deleted"; 
		model.addAttribute("delete", message);
		return "redirect:all";
	}
	

	
}
