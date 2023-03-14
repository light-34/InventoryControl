package com.inventory.entity;

import java.time.LocalDate;

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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "item_exp_date", length = 50 )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expDate;
	
	@Column(name = "item_price")
	@DecimalMin(value = "1.0", message = "Enter a valid number > 1.0")
	private double price;
	
	@Column(name = "item_quantity")
	@Min(1)
	private int quantity;
	
	@Column(name = "item_state", length = 10)
	@NotBlank(message = "Please enter purchased state")
	private String state;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.DETACH, 
			  CascadeType.MERGE,
			  CascadeType.PERSIST,
			  CascadeType.REFRESH})
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, 
			  CascadeType.MERGE,
			  CascadeType.PERSIST,
			  CascadeType.REFRESH})
	@JoinColumn(name = "product_id")
	private Product product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
