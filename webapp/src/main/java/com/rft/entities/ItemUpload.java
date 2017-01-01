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
@Table(name = "items")
@NamedStoredProcedureQuery(name = "itemupload", procedureName = "dbo.itemupload", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "itemid",         type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "itemname",       type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "description",    type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "picture",        type = Byte[].class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "price",          type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "itemquantity",   type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "unit",           type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "largedesc",      type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "manufacturerid", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "categoryid",     type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "quantity",       type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT,   name = "ret",            type = Long.class)})
public class ItemUpload implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
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
