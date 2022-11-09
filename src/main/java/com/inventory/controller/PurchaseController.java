package com.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.inventory.entity.Product;
import com.inventory.entity.Purchase;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.PurchaseRepository;
import com.inventory.service.ProductService;
import com.inventory.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private ProductService prodSerice;
	
	@Autowired
	private PurchaseService purService;
	
	@GetMapping("/addPurchase")
	public String showPurchaseForm(Model model) {
		
		model.addAttribute("purc", prodSerice.getAllProducts());
		model.addAttribute("pur", new Purchase());
		
		return "add-purchase";
	}
	
	@PostMapping("/purCreate")
	public String addPurchase(@Valid @ModelAttribute("pur") Purchase purchase, BindingResult result) {
		
		if (result.hasErrors()) {
			return "add-purchase";
		}
		
		purService.savePurchase(purchase);
		
		return "redirect:listPurchase";
		
	}
	
	@GetMapping("/listPurchase")
	public String listAllPurchases(Model model) {
		model.addAttribute("listAllPurchase", purService.getAllPurchases());
		model.addAttribute("repo", prodSerice.getAllProducts());
		
		return "list-purchases";
	}
	
	/*
	 * @GetMapping("/purUpdate/{id}") public String updatePurchase(@PathVariable int
	 * id, Model model) { Purchase purchase = purService.findAPurchase(id);
	 * List<Product> listProduct = prodSerice.getAllProducts();
	 * 
	 * model.addAttribute("thePur", purchase); model.addAttribute("prod",
	 * listProduct);
	 * 
	 * return "edit-purchase"; }
	 */
	
	@GetMapping("/purUpdate")
	public String updatePurchase(@RequestParam("id") int id, Model model) {
		Purchase purchase = purService.findAPurchase(id);
		List<Product> listProduct = prodSerice.getAllProducts();
		
		model.addAttribute("pur", purchase);
		model.addAttribute("prod", listProduct);
		
		return "edit-purchase";
	}
	
	
	/*
	 * @PostMapping("/updatePurchase") public String updateAPurchase(Model
	 * model, @Valid @ModelAttribute("pur") Purchase purchase, BindingResult result)
	 * { if (result.hasErrors()) { return "redirect:edit-purchase"; }
	 * 
	 * purService.updatePurchase(purchase);
	 * 
	 * model.addAttribute("success", "Update of the purchase is successfull!!!");
	 * 
	 * return "redirect:listPurchase";
	 * 
	 * }
	 */
	  
	  @PostMapping("/updatePurchase") public String updateAPurchase(HttpServletRequest req,
			   @Valid @ModelAttribute("pur") Purchase purchase, BindingResult result)
			  { if (result.hasErrors()) { return "redirect:edit-purchase"; }
			  
			  purService.updatePurchase(purchase);
			  
			  req.setAttribute("success", "Update of the purchase is successfull!!!");
			  
			  return "redirect:listPurchase";
			  
			  }
	 
	
	
	@DeleteMapping("/deletePurchase/{id}")
	public String deletePurchase(@PathVariable int id, Model model) {
		purService.deletePurchase(id);
		model.addAttribute("success", "Record Deleted Successfully");
		return "redirect:listPurchase";
	}

}
