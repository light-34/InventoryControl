package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findByProduct(long prodId);
	
}
