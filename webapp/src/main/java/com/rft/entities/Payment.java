package com.rft.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ParameterMode;

@Entity
@Table(name = "orderhead")
@NamedStoredProcedureQuery(name = "payment", procedureName = "dbo.payment", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "userid",   type = Long.class)})
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870590628722169477L;
	
	@Id 
	@GeneratedValue
	private Long orderid;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	
	
}
