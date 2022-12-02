package com.tms.entities;

import javax.persistence.*;

@Entity
@Table(name = "TICKET_DETAILS")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TICKET_ID")
	private int ticketId;
	//mapping with Route
	@OneToOne
	@JoinColumn(name = "ROUTE_ID")
	private Route route;
	
	
	@Column(name = "STATUS")
	private String status;

	public TicketDetails() {
		super();
	}

	public TicketDetails(int ticketId, Route route, Package pack, String status) {
		super();
		this.ticketId = ticketId;
		this.route = route;
		this.status = status;
	}
	// Getters and setters
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	//ToString
	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", route=" + route + ", status=" + status
				+ "]";
	}
	
	
}
