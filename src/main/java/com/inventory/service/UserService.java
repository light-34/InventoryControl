package com.inventory.service;

import java.util.List;

import com.inventory.entity.User;

public interface UserService {
	
	public void registerDefaultUser( User user);
	
	public List<User> getAllUsers();
}
