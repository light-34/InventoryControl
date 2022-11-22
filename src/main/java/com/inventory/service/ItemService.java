package com.inventory.service;

import java.util.List;

import com.inventory.entity.Item;

public interface ItemService {
	
	public List<Item> getAllItems();
	
	public Item findAnItem(long id);
	
	public void saveItem(Item item);
	
	public void updateItem(Item item);
	
	public void deleteItem(long id);
	
	public List<String> getStates();

}
