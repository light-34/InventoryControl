package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	Purchase findById(long id);
}
