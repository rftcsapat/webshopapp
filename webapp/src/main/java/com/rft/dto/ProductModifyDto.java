package com.rft.dto;

public class ProductModifyDto {
	
	public String shortDesc;
	
	public String longDesc;
	
	public String manufacturerId;
	
	public String categoryId;
	
	public String picturePath;
	
	public boolean isToRemove;
	

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
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

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public boolean isToRemove() {
		return isToRemove;
	}

	public void setToRemove(boolean isToRemove) {
		this.isToRemove = isToRemove;
	}
	
}
