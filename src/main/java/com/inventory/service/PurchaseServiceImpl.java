package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.Purchase;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseRepository purchaseRepository;
	
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		Purchase thePurchase = purchaseRepository.findById(purchase.getId());	
		thePurchase.setProdid(purchase.getProdid());
		thePurchase.setQuantity(purchase.getQuantity());
		thePurchase.setPrice(purchase.getPrice());
		thePurchase.setStore(purchase.getStore());
		thePurchase.setDate(purchase.getDate());
		
		purchaseRepository.save(thePurchase);
		
	}

	@Override
	public List<Purchase> getAllPurchases() {	
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase findAPurchase(int id) {	
		return purchaseRepository.findById(id);
	}

	@Override
	public void savePurchase(Purchase purchase) {
		purchaseRepository.save(purchase);		
	}

	@Override
	public void deletePurchase(int id) {
		purchaseRepository.deleteById(id);
		
	}
	

}
