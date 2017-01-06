package com.rft.dto;

public class ItemModDto {
	
	public String name;
	public String description;
	public String largeDesc;
	public String manufacturerId;
	public String categoryId;
	public String picture;
	public Byte[] pictureData;
	public Long itemQuantity;
	public String unit;
	public Long quantity;
	public Long price;
	public String isToRemove;

	public ItemModDto(String name, String description, String largeDesc, String manufacturerId, String categoryId,
			String picture, Long itemQuantity, String unit, Long quantity, Long price, String isToRemove) {
		super();
		this.name = name;
		this.description = description;
		this.largeDesc = largeDesc;
		this.manufacturerId = manufacturerId;
		this.categoryId = categoryId;
		this.picture = picture;
		this.itemQuantity = itemQuantity;
		this.unit = unit;
		this.quantity = quantity;
		this.price = price;
		this.isToRemove = isToRemove;
	}
	public ItemModDto() {
		super();
	}

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Byte[] getPictureData() {
		return pictureData;
	}
	public void setPictureData(Byte[] pictureData) {
		this.pictureData = pictureData;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLargeDesc() {
		return largeDesc;
	}
	public void setLargeDesc(String largeDesc) {
		this.largeDesc = largeDesc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getIsToRemove() {
		return isToRemove;
	}
	public void setIsToRemove(String isToRemove) {
		this.isToRemove = isToRemove;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemModDto ["+ " name=" + name + ", description=" + description + ", largeDesc="
				+ largeDesc + ", manufacturerId=" + manufacturerId + ", categoryId=" + categoryId + ", picture="
				+ picture + ", itemQuantity=" + itemQuantity + ", unit=" + unit + ", quantity=" + quantity + ", price="
				+ price + ", isToRemove=" + isToRemove + "]";
	}
	
}
