package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="items", indexes = {
	@Index(columnList = "itemname", unique = true)
})

public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Column(nullable=false, length=10)
	private String categoryid;

	
	public String getManufacturerid() {
		return manufacturerid;
	}

	public void setManufacturerid(String manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

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

	

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	
	public Item() {
		super();
	}
}
