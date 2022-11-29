package com.inventory.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.inventory.entity.Store;
import com.inventory.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@GetMapping("/all")
	public String getAllStores(Model model) {
		model.addAttribute("listAllStores", service.getAllStores());
		return "store/all-stores";
	}
	
	@GetMapping("/add")
	public String showStoreForm(Model model) {
		model.addAttribute("store", new Store());
		model.addAttribute("listState", service.getStates());
		return "store/add-store";
	}
	
	@PostMapping("/create")
	public String addStore(@Valid @ModelAttribute("store") Store store, BindingResult result) {
		if (result.hasErrors()) {
			return "store/add-store";
		}
		service.saveStore(store);
		return "redirect:all";
		
	}
	
	@GetMapping("/updateStore")
	public String updateStore(@RequestParam("id") long id, Model model) {
		
		Store store = service.findAStore(id);
		model.addAttribute("listState", service.getStates());
		model.addAttribute("store", store);
		
		return "store/edit-store";
	}
	  
	  @PostMapping("/update") 
	  public String updateStoreMethod(HttpServletRequest req,
			   @Valid @ModelAttribute("store") Store store, BindingResult result){ 
		  
		  if (result.hasErrors()) { 
			  return "redirect:edit-store"; 
			  }
		  
		  service.updateStore(store);
		  
		  req.setAttribute("success", "Update of the purchase is successfull!!!");
		  
		  return "redirect:all";  
	  
	  }
	
	@DeleteMapping("/delete")
	public String deleteTheStore(@RequestParam("id") long id, Model model) {
		
		service.deleteStore(id);
		
		model.addAttribute("success", "Record Deleted Successfully");
		
		return "redirect:all";
	}

}
