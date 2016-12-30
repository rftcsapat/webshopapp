package com.rft.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ParameterMode;

@Entity
@Table(name = "stock")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "SearchItemsInStock", procedureName = "dbo.SearchItems", resultClasses = { Stock.class }, 
	parameters = {
	  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "itemname",        type = String.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "manufacturerid",  type = Long.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "categoryid",      type = Long.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "minprice",        type = Long.class),
	  @StoredProcedureParameter(mode = ParameterMode.IN,  name = "maxprice",        type = Long.class)})
	})
public class SearchInStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4737145179528925L;
	
	@Id 
	@GeneratedValue
	private Long itemid;

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	
	

}
