package com.rft.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateDto {
	
	private long id;
	
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
	@Size(min=10, max=10, message="{birthDateError}")
	private String birthDate;

	@NotNull
	@Size(min=1, max=255)
	private String password;

	@NotNull
	@Size(min=1, max=255)
	private String passwordAgain;
	
	@NotNull
	@Size(min=1, max=1)
	private String role;
	
	@NotNull
	@Size(min=0, max=100000)
	private byte[] image;
	
	@Size(min=0, max=50)
	private String title;
	
	@Size(min=0, max=50)
	private String invitedby;
	
	@Size(min=0, max=255)
	private String address;

	@Size(min=0, max=50)
	private String email;

	@Size(min=0, max=50)
	private String phone;
	
	private long coins;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInvitedby() {
		return invitedby;
	}
	public void setInvitedby(String invitedby) {
		this.invitedby = invitedby;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getCoins() {
		return coins;
	}
	public void setCoins(long coins) {
		this.coins = coins;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "UserUpdateDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", birthDate=" + birthDate + ", password=" + password + ", passwordAgain=" + passwordAgain
				+ ", role=" + role + ", title=" + title + ", invitedby=" + invitedby + ", address=" + address
				+ ", email=" + email + ", phone=" + phone + ", coins=" + coins + "]";
	}
	
}
