package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.Product;
import com.inventory.service.FileProcessingService;
import com.inventory.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductService service;

	private FileProcessingService fileService;

	public ProductController(ProductService service, FileProcessingService fileService) {
		this.service = service;
		this.fileService = fileService;
	}

	@GetMapping("/all")
	public String getAllProducts(Model model) {
		List<Product> prodList = service.getAllProducts();
		model.addAttribute("listProducts", prodList);

		return "product/all-products";
	}

	@GetMapping("/details")
	public String getDetails(@RequestParam(name = "id") long id, Model model) {
		model.addAttribute("detail", service.findAProduct(id));

		return "product/detail-product";
	}

	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("prod", new Product());
		return "product/add-product";
	}

	/*
	 * @PostMapping("/create") public String createProduct(
	 * 
	 * @Valid @RequestParam String name,
	 * 
	 * @RequestParam String manufacturer,
	 * 
	 * @RequestParam String asin,
	 * 
	 * @RequestParam String ean,
	 * 
	 * @RequestParam String details,
	 * 
	 * @RequestParam("image") MultipartFile file, BindingResult bindingResult,
	 * RedirectAttributes attributes ) {
	 * 
	 * String sucMessage = "You have added an attributre successfully!!!!"; String
	 * failMessage = "Some thing wrong, Data has not been saved";
	 * 
	 * 
	 * fileService.save(file);
	 * 
	 * Product product = new Product(); product.setName(name);
	 * product.setManufacturer(manufacturer); product.setAsin(asin);
	 * product.setEan(ean); product.setDetails(details);
	 * product.setImage(StringUtils.cleanPath(file.getOriginalFilename()));
	 * 
	 * service.saveProduct(product);
	 * 
	 * if ( product != null ) { attributes.addFlashAttribute("success", sucMessage);
	 * } else { attributes.addFlashAttribute("success", failMessage); }
	 * 
	 * 
	 * return "redirect:all"; }
	 */

	@PostMapping("/create")
	public String createAProductDemo(@Valid @ModelAttribute("prod") Product product, 
			BindingResult result, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes attributes) {
		if (file.isEmpty()) {
			return "redirect:/";
		}
		if (product.getAsin().isEmpty()) {
			return "redirect:item/all";
		}
		
		product.setImage(file.getOriginalFilename());
		
		fileService.save(file);
		
		service.saveProduct(product);

		return "redirect:all";
	}

	/*
	 * @PostMapping("/create") public String createProduct(
	 * 
	 * @Valid @ModelAttribute("prod") Product prod,
	 * 
	 * @RequestParam("image") MultipartFile file, BindingResult bindingResult,
	 * RedirectAttributes attributes ) { String sucMessage =
	 * "You have added an attributre successfully!!!!"; String failMessage =
	 * "Some thing wrong, Data has not been saved";
	 * 
	 * if (bindingResult.hasErrors()) {
	 * 
	 * return "product/add-product";
	 * 
	 * } else {
	 * 
	 * prod.setImage(StringUtils.cleanPath(file.getOriginalFilename()));
	 * 
	 * fileService.save(file);
	 * 
	 * Product product = service.saveProduct(prod); if ( product != null ) {
	 * attributes.addFlashAttribute("success", sucMessage); } else {
	 * attributes.addFlashAttribute("success", failMessage); }
	 * 
	 * return "redirect:all"; }
	 */

	// Post mapping to save files
	/*
	 * @PostMapping("/upload") public String uploadImage(@RequestParam("image")
	 * MultipartFile file, RedirectAttributes attributes) { if (file.isEmpty()) {
	 * attributes.addFlashAttribute("message", "Please select a file to upload");
	 * return "product/add-product"; } fileService.save(file);
	 * 
	 * return "redirect:all"; }
	 */

	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam(name = "id") long id, Model model) {
		Product product = service.findAProduct(id);
		model.addAttribute("prod", product);
		return "product/edit-product";
	}

	@PostMapping("/update")
	public String updateProductMethod(@Valid @ModelAttribute("prod") Product prod, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "product/edit-product";
		} else {
			service.updateProduct(prod);
			return "redirect:all";
		}
	}

	@GetMapping("/delete")
	public String deleteTheProduct(@RequestParam("id") long id, Model model) {
		service.deleteProduct(id);
		String message = "Product with id : " + id + " has been deleted";
		model.addAttribute("delete", message);
		return "redirect:all";
	}

}
