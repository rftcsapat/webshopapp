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
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7609167686068917255L;
	@Id 
	 @GeneratedValue
	 private Long orderrowid;
	
	
	
}
	
	

