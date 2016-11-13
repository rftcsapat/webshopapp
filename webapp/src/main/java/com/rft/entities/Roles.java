package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="roles", indexes = {
	@Index(columnList = "roleid", unique = true)
})
public class Roles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long roleid;
	
	@Column(nullable=false, length=50)
	private String rolename;
	
	@Column(nullable=true, length=500)
	private String description;

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Roles() {
		super();
	}
	
	
	
}