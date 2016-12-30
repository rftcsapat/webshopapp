package com.rft.dto;

import java.util.List;

public class SearchMoreDto {
	
	public String name;
	public Long categoryId;
//	public List<String> categories;
	public Long manufacturerId;
//	public List<String> manufacturers;
	public Integer priceMin;
	public Integer priceMax;
	
	
	public SearchMoreDto(String name, Long categoryId, Long manufacturerId, Integer priceMin, Integer priceMax) {
		super();
		this.name = name;
		this.categoryId = categoryId;
		this.manufacturerId = manufacturerId;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}

	public SearchMoreDto() {
		super();
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}

	public Integer getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
	
}
