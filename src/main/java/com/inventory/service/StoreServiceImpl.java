package com.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Store;
import com.inventory.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	
	private StoreRepository repository;

	public StoreServiceImpl(StoreRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Store> getAllStores() {
		
		return repository.findAll();
	}

	@Override
	public Store findAStore(long id) {
		
		return repository.findById(id);
	}

	@Override
	public void saveStore(Store store) {
		
		repository.save(store);

	}

	@Override
	public void updateStore(Store store) {
		Store upStore = repository.findById(store.getId());
		upStore.setName(store.getName());
		upStore.setLocation(store.getLocation());
		upStore.setState(store.getState());
		
		repository.save(upStore);

	}

	@Override
	public void deleteStore(long id) {
		repository.deleteById(id);

	}

	@Override
	public List<String> getStates() {
		String [] strArr = {"ON", "MB", "QC", "NS"};
		Arrays.sort(strArr);
		return new ArrayList<>(Arrays.asList(strArr));
	}

}
