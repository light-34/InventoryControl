package com.inventory.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "details")
public class Detail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "prod_brand", length = 50, nullable = false)
	@NotEmpty(message = "Cant be Empty")
	private String brand;
	
	@Column(name = "prod_asin", length = 20, nullable = false, unique = true)
	@NotEmpty(message = "Cant be Empty")
	private String asin;
	
	@Column(name = "prod_ean", length = 15, nullable = true)
	private String ean;
	
	@Column(name = "prod_ingredients", length = 1000)
	private String ingredients;
	
	@Column(name = "prod_certificates", length = 100)
	private String certificates;
	
	@OneToOne(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product prod;

	public Detail() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Product getProduct() {
		return prod;
	}

	public void setProduct(Product prod) {
		this.prod = prod;
	}

}
