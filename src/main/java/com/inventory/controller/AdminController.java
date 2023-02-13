package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.service.RoleService;
import com.inventory.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public String getAllUsers(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "admin/all-users";
	}
	
	//In order to update user
	@PostMapping("/userUp")
	public String updateUser() {
		return null;
	}
	
	//In order to delete user
	@GetMapping("/userDel")
	public String deleteUser() {
		return null;
	}
	
	
	

}
