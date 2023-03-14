package com.inventory.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_name", length = 50)
	private String username;
	
	@Column(name = "review", columnDefinition = "text")
	@NotBlank(message = "This field cant be blank")
	private String review;
	
	@Column(name = "star_rate")
	@Min(1)
	@Max(5)
	private int rate;
	
	@Column(name = "rate_date", length = 30)
	private LocalDateTime date = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, 
			  CascadeType.MERGE,
			  CascadeType.PERSIST,
			  CascadeType.REFRESH})
	@JoinColumn(name = "product_id")
	private Product product;

	public Review() {	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
