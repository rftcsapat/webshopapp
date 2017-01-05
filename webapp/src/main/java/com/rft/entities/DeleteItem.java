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
@Table(name = "items")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "deleteitem", procedureName = "dbo.deleteitem", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "itemid",   type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT,   name = "ret",      type = Long.class)})
})
public class DeleteItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3138355653179727286L;
	
	@Id 
	@GeneratedValue
	private Long itemid;

}
