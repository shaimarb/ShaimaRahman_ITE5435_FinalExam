package com.sr.spring.finalex.models;

import jakarta.validation.constraints.Min;

public class Payment {
    private String id;
    
    @Min(value = 1, message = "Amount must be greater than zero")
    private int amount;
    
    private String date;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public Payment(String id, @Min(value = 1, message = "Amount must be greater than zero") int amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", date=" + date + "]";
	}

}
