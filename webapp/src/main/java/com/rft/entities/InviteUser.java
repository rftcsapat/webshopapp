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
@Table(name = "invitations")
@NamedStoredProcedureQuery(name = "inviteUser", procedureName = "dbo.invite", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "userid",   type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN,    name = "email",    type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT,   name = "ret",      type = Long.class)})
public class InviteUser implements Serializable{

	private static final long serialVersionUID = 9064812596606123279L;
	
	@Id 
	@GeneratedValue
	private Long invid;

	public Long getInvid() {
		return invid;
	}

	public void setInvid(Long invid) {
		this.invid = invid;
	}
	
	
}
