package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="orderhead", indexes = {
	@Index(columnList = "orderid", unique = true)
})

public class OrderHead {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderid;
	
	@Column(nullable=false)
	private long userid;
	
	@Column(nullable=false)
	private String orderprice;

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

	public String getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}
	public OrderHead() {
		super();
	}
	
}
