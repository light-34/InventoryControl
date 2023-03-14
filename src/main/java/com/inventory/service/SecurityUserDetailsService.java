package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inventory.entity.InventoryUserDetails;
import com.inventory.entity.User;
import com.inventory.repository.UsersRepository;

public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public SecurityUserDetailsService () {
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User is not found");
		}
		return new InventoryUserDetails(user) ;
	}

}
