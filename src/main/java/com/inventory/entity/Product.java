package com.inventory.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "prod_name", length = 30)
	@NotEmpty(message = "Cant be Empty")
	@Size(min = 2, max = 25, message = "Size needs to be between 2 to 25 characters")
	private String name;
	
	@Column(name = "prod_manufacturer", length = 50)
	@NotEmpty(message = "Cant be Empty")
	private String manufacturer;
	
	@Column(name = "prod_asin", unique = true)
	@NotEmpty(message = "Cant be Empty")
	private String asin;
	
	@Column(name = "prod_ean", length = 50)
	private String ean;
	
	@Column(name="img_link", length = 100)
	private String image;
	
	@Column(name = "prod_details", length = 1000)
	private String details;
	
	@Column(name = "prod_cre_date", length = 30)
	private LocalDateTime date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, 
			cascade = {CascadeType.DETACH, 
					  CascadeType.MERGE,
					  CascadeType.PERSIST,
					  CascadeType.REFRESH})
	private Set<Item> items;
	

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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
	
}
