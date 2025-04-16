package com.sr.spring.finalex.models;

import jakarta.validation.constraints.NotBlank;

public class AirlineTicket {
	@NotBlank(message = "Ticket ID is required")
    private String id;

    @NotBlank(message = "Ticket number is required")
    private String number;

    @NotBlank(message = "Ticket details are required")
    private String details;

    @NotBlank(message = "Price is required")
    private String price;

    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	public AirlineTicket(@NotBlank(message = "Ticket ID is required") String id,
			@NotBlank(message = "Ticket number is required") String number,
			@NotBlank(message = "Ticket details are required") String details,
			@NotBlank(message = "Price is required") String price) {
		super();
		this.id = id;
		this.number = number;
		this.details = details;
		this.price = price;
	}
	
	public AirlineTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", number=" + number + ", details=" + details + ", price=" + price + "]";
	}

}