package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	Item findById(long id);

}
