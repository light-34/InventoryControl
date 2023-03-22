package com.inventory.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "prod_name", length = 50)
	@NotEmpty(message = "Cant be Empty")
	@Size(min = 2, max = 50, message = "Size needs to be between 2 to 25 characters")
	private String name;
	
	@Column(name="prod_category", length = 70)
	@NotEmpty(message = "Cant be Empty")
	private String category;
	
	@Column(name = "prod_price", nullable = false)
	@DecimalMin(value = "1.0", message = "Enter a valid number > 1.0")
	private double price;
	
	@Column(name="img_link", length = 100)
	private String image;
	
	@Column(name = "prod_cre_date", length = 30)
	private LocalDateTime date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, 
			cascade = {CascadeType.DETACH, 
					  CascadeType.MERGE,
					  CascadeType.PERSIST,
					  CascadeType.REFRESH})
	private Set<Item> items;
	
	@OneToOne(mappedBy = "prod", fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private Detail details;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, 
					  CascadeType.MERGE,
					  CascadeType.PERSIST,
					  CascadeType.REFRESH})
	private List<Review> reviews;

	public Product() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Detail getDetails() {
		return details;
	}

	public void setDetails(Detail details) {
		this.details = details;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

}
