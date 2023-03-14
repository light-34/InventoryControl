package com.inventory.service;

import java.util.List;

import com.inventory.entity.Review;

public interface ReviewService {

	public List<Review> findAllReviews();
	
	public void saveReview(Review review);
	
	public List<Review> findReviewsForAProduct(long prodId);
	
	public void updateReview(Review review);
	
	public void deleteReview(long id);
	
}
