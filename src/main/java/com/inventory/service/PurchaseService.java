package com.inventory.service;

import java.util.List;

import com.inventory.entity.Purchase;

public interface PurchaseService {
	
	public void updatePurchase(Purchase purchase);
	
	public List<Purchase> getAllPurchases();
	
	public Purchase findAPurchase(long id);
	
	public void savePurchase(Purchase purchase);
	
	public void deletePurchase(long id);

}
