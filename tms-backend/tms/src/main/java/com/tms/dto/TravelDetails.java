package com.tms.dto;

import com.tms.entities.Bus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TravelDetails {
	private int travelsId;
	@NotNull
	@Size(min = 2, max = 20)
	@NotBlank
	private String travelsName;
	@NotNull
	@Size(min = 2, max = 20)
	@NotBlank
	private String agentName;
	@NotNull
	@Size(min = 2, max = 20)
	@NotBlank
	private String address;
	@NotNull
	@Size(min = 10, max = 10)
	@NotBlank
	private String contact;
	private int busId;

	private Bus bus;
	//Getters and Setters
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
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	//Constructor
	public TravelDetails(int travelsId, String travelsName, String agentName, String address, String contact) {
		super();
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}

}
