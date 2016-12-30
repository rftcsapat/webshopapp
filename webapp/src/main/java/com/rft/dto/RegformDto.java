package com.rft.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegformDto {
	
	@Size(min=1, max=255)
	private String title;
	
	@NotNull
	@Size(min=1, max=255)
	private String firstname;
	
	@NotNull
	@Size(min=1, max=255)
	private String lastname;
	
	@NotNull
	@Size(min=1, max=50)
	private String username;
	
	@NotNull
	@Size(min=1, max=255)
	private String email;
	
	@NotNull
	@Size(min=10, max=10, message="{birthDateError}")
	private String birthDate;

	@NotNull
	@Size(min=1, max=255)
	private String password;

	@NotNull
	@Size(min=1, max=255)
	private String passwordAgain;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "RegformDto [firstname=" + firstname + ", username=" + username + ", birthDate=" + birthDate + ", password="
				+ password + ", passwordAgain=" + passwordAgain + "]";
	}
	
}
