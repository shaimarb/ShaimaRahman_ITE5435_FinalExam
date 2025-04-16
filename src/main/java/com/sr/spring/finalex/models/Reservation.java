package com.sr.spring.finalex.models;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    
    @NotBlank(message = "Details are required")
    private String details;

    @FutureOrPresent(message = "Reservation date cannot be in the past")
    private LocalDate date;

    private AirlineTicket ticket;
    
    private Payment payment;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public AirlineTicket getTicket() {
		return ticket;
	}
	public void setTicket(AirlineTicket ticket) {
		this.ticket = ticket;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	public Reservation(String id, @NotBlank(message = "Details are required") String details,
			@FutureOrPresent(message = "Reservation date cannot be in the past") LocalDate date, AirlineTicket ticket,
			Payment payment) {
		super();
		this.id = id;
		this.details = details;
		this.date = date;
		this.ticket = ticket;
		this.payment = payment;
	}
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", details=" + details + ", date=" + date + ", ticket=" + ticket + ", payment="
				+ payment + "]";
	}
	
}
