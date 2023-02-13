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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "pur_date", length = 50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;	
	
	@Column(name = "nr_items")
	@Min(1)
	private int nrItem;

	@OneToMany(mappedBy = "purchase", 
			fetch = FetchType.LAZY, 
			orphanRemoval = true,
			cascade = {CascadeType.DETACH, 
							  CascadeType.MERGE,
							  CascadeType.PERSIST,
							  CascadeType.REFRESH})
	private Set<Item> items;
	
	@ManyToOne( fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, 
							  CascadeType.MERGE,
							  CascadeType.PERSIST,
							  CascadeType.REFRESH})
	@JoinColumn(name = "store_id", referencedColumnName = "id")
	private Store store;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getNrItem() {
		return nrItem;
	}

	public void setNrItem(int nrItem) {
		this.nrItem = nrItem;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	


}
