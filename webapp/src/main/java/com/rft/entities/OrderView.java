package com.rft.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="orderview", indexes = {
	@Index(columnList = "orderid", unique = true)
})
public class OrderView {
	
	@Id
	@Column
	private long orderid;
	
	@Column(nullable=false)
	private long userid;
	
	@Column(nullable=false)
	private long itemid;
	
	@Column(nullable=false)
	private long quantity;
	
	@Column(nullable=false)
	private long price;
	
	@Column(nullable=false)
	private long orderstatusid;
	
	@Column(nullable=false, length=10)
	private String statusdate;
	
	@Column(nullable=false, length=50)
	private long orderstatusname;
	
	@Column(nullable=false, length=500)
	private long description;

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public long getOrderstatusid() {
		return orderstatusid;
	}

	public void setOrderstatusid(long orderstatusid) {
		this.orderstatusid = orderstatusid;
	}

	public String getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(String statusdate) {
		this.statusdate = statusdate;
	}

	public long getOrderstatusname() {
		return orderstatusname;
	}

	public void setOrderstatusname(long orderstatusname) {
		this.orderstatusname = orderstatusname;
	}

	public long getDescription() {
		return description;
	}

	public void setDescription(long description) {
		this.description = description;
	}

	public OrderView() {
		super();
	}
	
}