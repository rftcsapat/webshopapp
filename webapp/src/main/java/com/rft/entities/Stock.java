package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="stock", indexes = {
	@Index(columnList = "itemname", unique = true)
})
public class Stock {
	
	@Id
	@Column
	private long itemid;
	
	@Column(nullable=false, length=50)
	private String itemname;
	
	@Column(nullable=true, length=1000)
	private String description;
	
	@Column(nullable=true, length=100000)
	private byte[] picture;
	
	@Column(nullable=false, length=10)
	private String price;
	
	@Column(nullable=false, length=10)
	private String itemquantity;
	
	@Column(nullable=false, length=50)
	private String unit;
	
	@Column(nullable=false, length=4000)
	private String largedesc;
	
	@Column(nullable=false, length=10)
	private String manufacturerid;
	
	@Column(nullable=false, length=50)
	private String manufacturername;
	
	@Column(nullable=true, length=500)
	private String manufacturerdesc;
	
	@Column(nullable=false, length=10)
	private String categoryid;
	
	@Column(nullable=false, length=50)
	private String categoryname;
	
	@Column(nullable=true, length=500)
	private String categorydesc;
	
	@Column(nullable=false, length=10)
	private String quantity;

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getItemquantity() {
		return itemquantity;
	}

	public void setItemquantity(String itemquantity) {
		this.itemquantity = itemquantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLargedesc() {
		return largedesc;
	}

	public void setLargedesc(String largedesc) {
		this.largedesc = largedesc;
	}

	public String getManufacturerid() {
		return manufacturerid;
	}

	public void setManufacturerid(String manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

	public String getManufacturername() {
		return manufacturername;
	}

	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}

	public String getManufacturerdesc() {
		return manufacturerdesc;
	}

	public void setManufacturerdesc(String manufacturerdesc) {
		this.manufacturerdesc = manufacturerdesc;
	}
	
	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydesc() {
		return categorydesc;
	}

	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public Stock() {
		super();
	}
}
