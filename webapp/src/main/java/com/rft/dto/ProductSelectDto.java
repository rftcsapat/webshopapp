package com.rft.dto;

public class ProductSelectDto {
	
	public String itemId;

	public ProductSelectDto(String itemId) {
		super();
		this.itemId = itemId;
	}
	public ProductSelectDto() {
		super();
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
