package com.rft.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

public class AddToBasketDto {
	
	@NotNull
//	@Size(min=1, max=20)
	@Min(0)
	@Max(1000)
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
