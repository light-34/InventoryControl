package com.inventory.controller;

import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.dto.Items;
import com.inventory.entity.Item;
import com.inventory.entity.Purchase;
import com.inventory.service.ItemService;
import com.inventory.service.ProductService;
import com.inventory.service.PurchaseService;
import com.inventory.service.StoreService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ItemService service;

	@Autowired
	private StoreService storeService;

	@GetMapping("/add")
	public String addAPurchase(Model model) {
		model.addAttribute("pur", new Purchase());

		model.addAttribute("listStores", storeService.getAllStores());

		return "testweb/add-pur-first";
	}

	@PostMapping("/create")
	public String createAPurchase(@Valid @ModelAttribute("pur") Purchase purchase, BindingResult result,
			RedirectAttributes attributes, Model model) {
		
		if (result.hasErrors()) {
			return "test/add";
		}
		
		purchaseService.savePurchase(purchase);
		
		  attributes.addFlashAttribute("thePurchase", purchase);

		return "redirect:addItem";
	}

	@GetMapping("/addItem")
	public String addItemsOfPurchase(Model model ) {	
		model.addAttribute("purit", new Items());
		model.addAttribute("listProduct", productService.getAllProducts());
		model.addAttribute("listPurchases", purchaseService.getAllPurchases());
		model.addAttribute("states", service.getStates());
		return "testweb/add-items-first";
	}

	@PostMapping("/createItems")
	public String createPurItems(@Valid @ModelAttribute("purit") Items item, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:addItem";
		}

		service.saveListItems(item);
		
		
		return "redirect:http://localhost:8080/item/all";
	}
	
	@RequestMapping("/showData")
	public String showDataMethod(@Valid @ModelAttribute("purit") Items items, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:addItem";
		}
		model.addAttribute("listItems", items);
		return "testweb/add-items-second";
	}

}
