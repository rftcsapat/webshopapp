package com.rft.dto;

public class InvitationDto {
	public String email;
	
	public InvitationDto(String email) {
		super();
		this.email = email;
	}

	public InvitationDto() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
