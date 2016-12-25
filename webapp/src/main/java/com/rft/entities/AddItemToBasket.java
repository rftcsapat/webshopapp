package com.rft.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.persistence.ParameterMode;

@Entity
@Table(name = "orders")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "addItem", procedureName = "dbo.addItem", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "userid", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "itemid", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "quantity", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ret", type = Long.class)})
})
public class AddItemToBasket implements Serializable 
{
	 @Id 
	 @GeneratedValue
	 private Long id;
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -7811934890380525365L;
//
//
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long orderrowid;
//	
//	private Long userid;
//	
//	private Long itemid;
//	
//	private Long quantity;
//	
//	private Long ret;
//	
//	
//
//	
//	public Long getOrderrowid() {
//		return orderrowid;
//	}
//
//	public void setOrderrowid(Long orderrowid) {
//		this.orderrowid = orderrowid;
//	}
//
//	public Long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
//
//	public Long getItemid() {
//		return itemid;
//	}
//
//	public void setItemid(Long itemid) {
//		this.itemid = itemid;
//	}
//
//	public Long getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Long quantity) {
//		this.quantity = quantity;
//	}
//
//	public Long getRet() {
//		return ret;
//	}
//
//	public void setRet(Long ret) {
//		this.ret = ret;
//	}
//
//
//
//	public AddItemToBasket(Long id, Long userid, Long itemid, Long quantity, Long ret) {
//		super();
//		this.orderrowid = id;
//		this.userid = userid;
//		this.itemid = itemid;
//		this.quantity = quantity;
//		this.ret = ret;
//	}
//
//	public AddItemToBasket() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	
}
	
	

