package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.entity.Detail;

public interface DetailRepository  extends JpaRepository<Detail, Long>{

	Detail findById(long id);
	
	Detail findByProdEquals(long prod);

	
}
