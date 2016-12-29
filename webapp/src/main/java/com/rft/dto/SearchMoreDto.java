package com.rft.dto;

import java.util.List;

public class SearchMoreDto {
	
	public String name;
	public String category;
//	public List<String> categories;
	public String manufacturer;
//	public List<String> manufacturers;
	public Integer priceMin;
	public Integer priceMax;
	
	public SearchMoreDto(String name, String category, String manufacturer, Integer priceMin, Integer priceMax) {
		super();
		this.name = name;
		this.category = category;
		this.manufacturer = manufacturer;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}

	public SearchMoreDto() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
//	public List<String> getCategories() {
//		return categories;
//	}
//	public void setCategories(List<String> categories) {
//		this.categories = categories;
//	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
//	public List<String> getManufacturers() {
//		return manufacturers;
//	}
//	public void setManufacturers(List<String> manufacturers) {
//		this.manufacturers = manufacturers;
//	}

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
