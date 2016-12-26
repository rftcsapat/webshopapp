package com.rft.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddToBasketDto {
	
	@NotNull
//	@Size(min=1, max=20)
	public Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public AddToBasketDto(Integer quantity) {
		super();
		this.quantity = quantity;
	}

	public AddToBasketDto() {
		super();
	}
	
}
