package com.inventory.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.entity.Item;

@Component
public class Items {
	
	private List<Item> itemList = new ArrayList<>();
	
	public Items() {
	}

	public Items(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void addItems(Item item) {
		this.itemList.add(item);
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	
}
