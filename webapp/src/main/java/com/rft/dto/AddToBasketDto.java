package com.rft.dto;

public class AddToBasketDto {
	
	public int quantity;

	public AddToBasketDto(int quantity) {
		super();
		this.quantity = quantity;
	}

	public AddToBasketDto() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
