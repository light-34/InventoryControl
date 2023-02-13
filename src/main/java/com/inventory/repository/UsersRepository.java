package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
