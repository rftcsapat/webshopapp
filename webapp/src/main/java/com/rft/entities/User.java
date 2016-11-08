
package com.rft.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users", indexes = {
	@Index(columnList = "username", unique = true)
})
public class User {
	
	public static final int NAME_MAX = 64;
	public static final int USERNAME_MAX = 64;
	public static final int BIRTHDATE_MAX = 10;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@SequenceGenerator(name="SEQMYCLASSID", sequenceName="SEQMYCLASSID")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQMYCLASSID")
	private long id;
	
	@Column(nullable=false, length=NAME_MAX)
	private String firstname;
	
	@Column(nullable=false, length=NAME_MAX)
	private String lastname;
	
	@Column(nullable=false, length=USERNAME_MAX)
	private String username;
	
	@Column(nullable=false, length=BIRTHDATE_MAX)
	private String birthdate;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, length=1)
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User() {
		super();
	}
	
}
