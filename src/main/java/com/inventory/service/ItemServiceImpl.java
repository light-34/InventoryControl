package com.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.dto.Items;
import com.inventory.entity.Item;
import com.inventory.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository repository;

	public ItemServiceImpl(ItemRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Item> getAllItems() {
		return repository.findAll();
	}

	@Override
	public Item findAnItem(long id) {
		return repository.findById(id);
	}

	@Override
	public void saveItem(Item item) {
		repository.save(item);
		
	}

	@Override
	public void updateItem(Item item) {
		Item upItem = repository.findById(item.getId());
		upItem.setExpDate(item.getExpDate());
		upItem.setPrice(item.getPrice());
		upItem.setQuantity(item.getQuantity());
		upItem.setState(item.getState());
		upItem.setPurchase(item.getPurchase());
		upItem.setProduct(item.getProduct());
		repository.save(upItem);
	}

	@Override
	public void deleteItem(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<String> getStates() {
		String [] strArr = {"ON", "MB", "QC", "NS"};
		Arrays.sort(strArr);
		return new ArrayList<>(Arrays.asList(strArr));
	}

	@Override
	public void saveListItems(Items item) {
		
		repository.saveAll(item.getItemList());
		//item.getItemList().stream().forEach(e -> repository.save(e));
		//Arrays.asList(item).stream().forEach(e -> repository.saveAll(e));
		
	}

}
