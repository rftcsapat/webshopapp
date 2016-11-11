package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="orders", indexes = {
	@Index(columnList = "orderrowid", unique = true)
})

public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderrowid;
	
	@Column(nullable=false)
	private long orderid;
	
	@Column(nullable=false)
	private long itemid;
	
	@Column(nullable=false)
	private long quantity;

	@Column(nullable=false)
	private long price;
	
	public long getOrderrowid() {
		return orderrowid;
	}

	public void setOrderrowid(long orderrowid) {
		this.orderrowid = orderrowid;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Orders() {
		super();
	}
	
}
