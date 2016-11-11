package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="warehouse", indexes = {
	@Index(columnList = "itemid", unique = true)
})
public class Warehouse {
	
	@Id
	private long itemid;
	
	@Column(nullable=false)
	private long quantity;

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
	
	public Warehouse() {
		super();
	}
	
}