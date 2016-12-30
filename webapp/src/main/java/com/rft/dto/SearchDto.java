package com.rft.dto;

import javax.validation.constraints.Size;

public class SearchDto {
	
	@Size(min=0, max=30)
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
