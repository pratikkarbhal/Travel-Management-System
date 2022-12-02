package com.tms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "travels")
public class Travels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int travelsId;
	private String travelsName;
	private String agentName;
	private String address;
	private String contact;

	//mapping with Bus
	@OneToOne(mappedBy = "travel", cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id")
	private Bus bus;

	// Constructor without Id
	public Travels(String travelsName, String agentName, String address, String contact) {
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}

	// Constructor with id
	public Travels(int travelsId, String travelsName, String agentName, String address, String contact) {
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}

	// default constructor
	public Travels() {
	}

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

	// Getter and Setter for Bus
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	// Method to add Bus
	public void addBus(Bus bus) {
		bus.setTravel(this);
		this.setBus(bus);
	}

	// ToString with Bus
	@Override
	public String toString() {
		return "Travels [travelsId=" + travelsId + ", travelsName=" + travelsName + ", agentName=" + agentName
				+ ", address=" + address + ", contact=" + contact + ", bus=" + bus + "]";
	}

}
