package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
	
	Store findById(long id);

}
