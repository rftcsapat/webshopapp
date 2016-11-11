package com.rft.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Warehouse;

public interface WarehouseRepository  extends JpaRepository<Warehouse, Long>{
	Warehouse findByItemid(long itemid);
	List<Warehouse> findAll();
}