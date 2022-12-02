package com.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue
	private int routeId;
	private String routeFrom;
	private String routeTo;
	//mapping with bus
	@OneToOne
	private Bus bus;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private LocalDate doj;
	private String pickupPoint;
	private double fare;
	//mapping with TicketDetails
	@OneToOne(mappedBy = "route", cascade = CascadeType.ALL)
	private TicketDetails ticketDetails;

	// default constructor
	public Route() {
	}

	
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj + ", pickupPoint=" + pickupPoint
				+ ", fare=" + fare + ", TicketDetails=" + ticketDetails + "]";
	}



	public Route(int routeId, String routeFrom, String routeTo, LocalDateTime departureTime, LocalDateTime arrivalTime,
			LocalDate doj, String pickupPoint, double fare, TicketDetails ticketDetails) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
		this.ticketDetails = ticketDetails;
	}







	public Route(int routeId, String routeFrom, String routeTo, Bus bus, LocalDateTime departureTime,
			LocalDateTime arrivalTime, LocalDate doj, String pickupPoint, double fare) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.bus = bus;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
	}


	public Route(String routeFrom, String routeTo, LocalDateTime departureTime, LocalDateTime arrivalTime,
			LocalDate doj, String pickupPoint, double fare) {
		super();
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
	}


	// Getters and Setters
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	// Getters and Setters for ticket_details
	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	public void addTicketDetails(TicketDetails ticketDetails) {
		ticketDetails.setRoute(this);
		this.setTicketDetails(ticketDetails);
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	
}
