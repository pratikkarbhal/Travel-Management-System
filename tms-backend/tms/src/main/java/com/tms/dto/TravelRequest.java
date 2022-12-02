package com.tms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tms.entities.Bus;

public class TravelRequest {

	private int travelsId;
	@NotNull
	private String travelsName;
	@NotNull
	private String agentName;
	@NotNull
	private String address;
	@NotNull @Size(min = 10,max=10)
	private String contact;

	private Bus bus;

	// Getters and Setters
	public int getTravelsId() {
		return travelsId;
	}

	public void setTravelsId(int travelsId) {
		this.travelsId = travelsId;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
