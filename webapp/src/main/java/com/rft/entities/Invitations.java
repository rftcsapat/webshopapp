package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="invitations", indexes = {
	@Index(columnList = "userid", unique = true)
})

public class Invitations {
	
	@Column(nullable=false)
	private long userid;
	
	@Column(nullable=false, length=50)
	private String email;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	public Invitations() {
		super();
	}
}
