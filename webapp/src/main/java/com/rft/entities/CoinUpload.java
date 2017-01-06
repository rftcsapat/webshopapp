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
@Table(name = "coinhistory")
@NamedStoredProcedureQuery(name = "coinChange", procedureName = "dbo.coinChange", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "userid",   type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "cash",     type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "coins",    type = Long.class)})
public class CoinUpload implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316033188036864069L;
	
	@Id 
	@GeneratedValue
	private Long coinhistoryid;

	public Long getCoinhistoryid() {
		return coinhistoryid;
	}

	public void setCoinhistoryid(Long coinhistoryid) {
		this.coinhistoryid = coinhistoryid;
	}

	
	
	

}
