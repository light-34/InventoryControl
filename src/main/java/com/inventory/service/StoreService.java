package com.inventory.service;

import java.util.List;
import com.inventory.entity.Store;

public interface StoreService {
	
	public List<Store> getAllStores();
	
	public Store findAStore(long id);
	
	public void saveStore(Store store);
	
	public void updateStore(Store store);
	
	public void deleteStore(long id);
	
	public List<String> getStates();

}
