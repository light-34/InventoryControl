package com.inventory.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.Review;
import com.inventory.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private final ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@GetMapping("/add")
	public String addReveiw(Model model, Authentication authentication, Principal principal) {
		model.addAttribute("rev", new Review());
		model.addAttribute("use", authentication.getName());
		return "review/add-review";
	}
	
	@PostMapping("/create")
	public String addReviewPost(@Valid @ModelAttribute("rev") Review review, 
												BindingResult result, 
												RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "review/add-review";
		}
		
		service.saveReview(review);
		
		return "redirect:../home";
		//return "redirect:review/user-reviews";
	}
	
	

}
