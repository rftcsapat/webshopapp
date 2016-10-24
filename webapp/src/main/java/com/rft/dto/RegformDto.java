package com.rft.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegformDto {
	
	@NotNull
	@Size(min=1, max=255)
	private String name;
	
	@NotNull
	@Size(min=1, max=50)
	private String username;
	
	@NotNull
	@Size(min=10, max=10, message="{birthDateError}")
	private String birthDate;

	@NotNull
	@Size(min=1, max=255)
	private String password;

	@NotNull
	@Size(min=1, max=255)
	private String passwordAgain;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return "RegformDto [name=" + name + ", username=" + username + ", birthDate=" + birthDate + ", password="
				+ password + ", passwordAgain=" + passwordAgain + "]";
	}
	
}
