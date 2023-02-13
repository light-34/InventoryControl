package com.inventory.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.Purchase;
import com.inventory.service.PurchaseService;
import com.inventory.service.StoreService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService service;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/all")
	public String getAllPurchases(Model model) {
		model.addAttribute("listAllPurchase", service.getAllPurchases());
		return "purchase/all-purchases";
	}
	
	@GetMapping("/add")
	public String showPurchaseForm(Model model) {
		model.addAttribute("pur", new Purchase());
		model.addAttribute("listStores", storeService.getAllStores());
		return "purchase/add-purchase";
	}
	
	@PostMapping("/create")
	public String addPurchase(@Valid @ModelAttribute("pur") Purchase purchase, BindingResult result) {
		if (result.hasErrors()) {
			return "purchase/add-purchase";
		}
		service.savePurchase(purchase);
		return "redirect:all";
		
	}
	
	@GetMapping("/updatePurchase")
	public String updatePurchase(@RequestParam("id") long id, Model model) {
		Purchase purchase = service.findAPurchase(id);
		model.addAttribute("pur", purchase);
		return "purchase/edit-purchase";
	}
	  
	  @PostMapping("/update") public String updatePurchaseMethod(RedirectAttributes attributes,
			   @Valid @ModelAttribute("pur") Purchase purchase, BindingResult result){ 
		  if (result.hasErrors()) { return "redirect:edit-purchase"; }
		  service.updatePurchase(purchase);
		  attributes.addFlashAttribute("success", "Update of the purchase is successfull!!!");
		  return "redirect:all";  
	  
	  }
	
	@DeleteMapping("/delete")
	public String deleteThePurchase(@RequestParam("id") long id, RedirectAttributes attributes) {
		service.deletePurchase(id);
		attributes.addFlashAttribute("success", "Record Deleted Successfully");
		return "redirect:all";
	}

}
