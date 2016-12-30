package com.rft.dto;

public class CreditDto {
	
	public String cardNumber;
	public String cardExpiration;
	public String cardCvc;
	public String packageName;
	
	public CreditDto(String cardNumber, String cardExpiration, String cardCvc, String packageName) {
		super();
		this.cardNumber = cardNumber;
		this.cardExpiration = cardExpiration;
		this.cardCvc = cardCvc;
		this.packageName = packageName;
	}
	public CreditDto() {
		super();
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiration() {
		return cardExpiration;
	}
	public void setCardExpiration(String cardExpiration) {
		this.cardExpiration = cardExpiration;
	}
	public String getCardCvc() {
		return cardCvc;
	}
	public void setCardCvc(String cardCvc) {
		this.cardCvc = cardCvc;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
