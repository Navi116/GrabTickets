package com.edu.eventbooking.dao;

public class PaymentRequest {

    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
    
    
	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentRequest(String cardNumber, String cardHolderName, String expirationDate, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
    
    
    
    
    

    
}
