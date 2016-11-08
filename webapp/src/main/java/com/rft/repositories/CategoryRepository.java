package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryname(String categoryname);
	Category findByCategoryid(long categoryid);
	List<Category> findAll();
}
