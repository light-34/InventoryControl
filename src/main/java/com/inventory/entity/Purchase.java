package com.inventory.entity;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="pur_store", length = 40)
	@NotEmpty(message = "Can't be Empty")
	private String store;
	
	@Column(name = "pur_date", length = 50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;	

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, 
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
