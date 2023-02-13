package com.inventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.User;
import com.inventory.service.UserService;

@Controller
@RequestMapping("/log")
public class LoginController {
		
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login/login";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "login/reg-page";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes attributes) {
		
		  if (result.hasErrors()) { return "login/reg-page"; }
		 
				
		userService.registerDefaultUser(user);
		
		String message = user.getfName().toUpperCase() + " " + user.getlName().toUpperCase() + " has been sucessfully registered";
		
		attributes.addFlashAttribute("suc", message );
		
		return "redirect:success";
	}
		
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "login/access-denied";
	}
	
	@GetMapping("/success")
	public String successPage( ) {
		return "login/success-page";
	}
	
	@GetMapping("/hello")
	public String helloPage( ) {
		return "login/hello";
	}

}
