package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="invitations", indexes = {
	@Index(columnList = "invid", unique = true)
})
public class Invitations {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long invid;
	
	@Column(nullable=false)
	private long userid;
	
	@Column(nullable=false)
	private long email;

	public long getInvid() {
		return invid;
	}

	public void setInvid(long invid) {
		this.invid = invid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getEmail() {
		return email;
	}

	public void setEmail(long email) {
		this.email = email;
	}
	
	public Invitations() {
		super();
	}
	
}
