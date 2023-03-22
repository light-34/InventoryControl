package com.inventory.controller;

import java.util.Arrays;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.Detail;
import com.inventory.entity.Product;
import com.inventory.repository.DetailRepository;
import com.inventory.service.FileProcessingService;
import com.inventory.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService service;

	private final FileProcessingService fileService;
	
	private DetailRepository detailRepository;

	public ProductController(ProductService service, FileProcessingService fileService, DetailRepository detailRepository) {
		this.service = service;
		this.fileService = fileService;
		this.detailRepository = detailRepository;
	}

	//Gets all of the product
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		List<Product> prodList = service.getAllProducts();
		model.addAttribute("listProducts", prodList);

		return "product/all-products";
	}

	//Add a new Product
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("prod", new Product());
		model.addAttribute("listCategory", service.categorySelect());
		return "product/add-product";
	}

	//Create product in DB
	@PostMapping("/create")
	public String createAProductDemo(@Valid @ModelAttribute("prod") Product product, 
			BindingResult result, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes attributes, Model model) 
	{
		if (result.hasErrors()) {
			model.addAttribute("listCategory", service.categorySelect());
			return "product/add-product";
		} else if (file.isEmpty()) {
			return "redirect:/";
		} else {
			product.setImage(file.getOriginalFilename());
			
			fileService.save(file);
			
			service.saveProduct(product);
			
			attributes.addFlashAttribute("prodId", product);

			return "redirect:addDetails";
		}
	
	}

	//Update a product
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam(name = "id") long id, Model model) {
		Product product = service.findAProduct(id);
		model.addAttribute("prod", product);
		model.addAttribute("listCategory", service.categorySelect());
		return "product/edit-product";
	}

	//Create updated product in DB
	@PostMapping("/update")
	public String updateProductMethod(@Valid @ModelAttribute("prod") Product prod, BindingResult result, 
			@RequestParam("file") MultipartFile file) {
		if (result.hasErrors()) {
			return "product/edit-product";
		} else {
			prod.setImage(file.getOriginalFilename());
			fileService.save(file);
			service.updateProduct(prod);
			return "redirect:all";
		}
	}

	//Delete a Product
	@GetMapping("/delete")
	public String deleteTheProduct(@RequestParam("id") long id, RedirectAttributes attributes) {
		service.deleteProduct(id);
		String [] message = {"Product with id : " + id + " has been deleted", "Product with id : " + id + " cant be deleted"};

		if(service.existsWithId(id)) {
			attributes.addFlashAttribute("success", message[1]);
		} else {
			attributes.addFlashAttribute("success", message[0]);
		}
		return "redirect:all";
	}
	
	//Add details of a product
	@GetMapping("/addDetails")
	public String addDetailsOfProducts(Model model) {
		model.addAttribute("prodDetail", new Detail());
		return "product/add-details";
	}
	
	//Create details of a product in DB
	@PostMapping("/addDetails")
	public String createDetailsOfProduct(@Valid @ModelAttribute("prodDetail") Detail detail, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:addDetails";
		} else {
			
			detail.setAsin(detail.getAsin().toUpperCase());
			service.saveDetail(detail);
			
			return "redirect:all";
		}

	}
	
	//Gets details of a product
	@GetMapping("/getDetails")
	public String getDetailOfAProduct(@RequestParam("id") long id, Model model) {
		
		Product product = service.findAProduct(id);	
		model.addAttribute("pr", product);
		model.addAttribute("det", product.getDetails());
		
		return "product/detail-product";
	}
	
	//it is used in the jsp for creating checkboxes for the elements
	@ModelAttribute("certificateModelAttribute")
	public List<String> getCertificeteModels() {
		return Arrays.asList("Halal", "Koshar", "Vegan");
	}

}
