package com.rft.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="orderstatuschange", indexes = {
	@Index(columnList = "orderid", unique = true)
})
public class OrderStatusChange {

	@Column(nullable=false)
	private long orderid;
	
	@Column(nullable=false)
	private long orderstatusid;
	
	@Column(nullable=false,length=10)
	private String statusdate;

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
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
	
	public OrderStatusChange() {
		super();
	}
}
