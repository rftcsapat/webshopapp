package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Item;



public interface ItemRepository extends JpaRepository<Item, Long>{
	Item findByItemname(String itemname);
	Item findByItemid(long itemid);
	List<Item> findByCategoryid(String categoryid);
	List<Item> findByManufacturerid(String manufacturerid);
	List<Item> findAll();

}
