package com.inventory.entity;

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
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "store_name", length = 50)
	@NotBlank(message = "This field cant be blank")
	private String name;
	
	@Column(name = "store_location", length = 50)
	@NotBlank(message = "This field cant be blank")
	private String location;
	
	@Column(name = "store_state", length = 2)
	private String state;
	
	@OneToMany(mappedBy = "store", 
			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, 
					  CascadeType.MERGE,
					  CascadeType.PERSIST,
					  CascadeType.REFRESH})
	private Set<Purchase> purchase;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(Set<Purchase> purchase) {
		this.purchase = purchase;
	}


	
}
