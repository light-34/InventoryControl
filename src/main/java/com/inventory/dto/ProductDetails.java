package com.inventory.dto;

public class ProductDetails {
	
	private long id;
	
	private String name;
	
	private String category;

	private double price;
	
	//private String image;
	
	private String brand;
	
	private String asin;
	
	private String ean;
	
	private String ingredients;
	
	private String certificates;
	

	public ProductDetails() {
		super();
	}
	
	

	public ProductDetails(long id, String name, String category, double price,
			/* String image, */ String brand, String asin,
			String ean, String ingredients, String certificates) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		//this.image = image;
		this.brand = brand;
		this.asin = asin;
		this.ean = ean;
		this.ingredients = ingredients;
		this.certificates = certificates;
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

	/*
	 * public String getImage() { return image; }
	 * 
	 * public void setImage(String image) { this.image = image; }
	 */

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCertificates() {
		return certificates;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}
	
	
}
