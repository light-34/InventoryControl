package com.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Review;
import com.inventory.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	
	private final ReviewRepository repository;
	
	public ReviewServiceImpl(ReviewRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Review> findAllReviews() {
		
		return repository.findAll();
	}

	@Override
	public void saveReview(Review review) {
		repository.save(review);
	}

	@Override
	public List<Review> findReviewsForAProduct(long prodId) {
		
		return repository.findByProduct(prodId);
	}

	@Override
	public void updateReview(Review review) {
		Review upReview = new Review();
		upReview.setRate(review.getRate());
		upReview.setReview(review.getReview());
		
		saveReview(upReview);
		
	}

	@Override
	public void deleteReview(long id) {
		repository.deleteById(id);
		
	}

}
