package com.rft.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	Stock findByItemname(String itemname);
	Stock findByItemid(long itemid);
	List<Stock> findByCategoryname(String categoryname);
	Page<Stock> findByCategoryname(Pageable pageable, String categoryname);
	List<Stock> findByCategoryid(String categoryid);
	List<Stock> findByManufacturername(String manufacturername);
	List<Stock> findByManufacturerid(String manufacturerid);
	List<Stock> findAll();
}
