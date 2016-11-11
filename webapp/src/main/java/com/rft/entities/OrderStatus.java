package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="orderstatus", indexes = {
	@Index(columnList = "orderstatusid", unique = true)
})
public class OrderStatus {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderstatusid;
	
	@Column(nullable=false,length=50)
	private String ordersatusname;
	
	@Column(nullable=true,length=500)
	private String description;

	public long getOrderstatusid() {
		return orderstatusid;
	}

	public void setOrderstatusid(long orderstatusid) {
		this.orderstatusid = orderstatusid;
	}

	public String getOrdersatusname() {
		return ordersatusname;
	}

	public void setOrdersatusname(String ordersatusname) {
		this.ordersatusname = ordersatusname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public OrderStatus() {
		super();
	}

}
