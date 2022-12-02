package com.tms.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEEDBACK_ID")
	private int feedbackId;
	//MAPPING WITH CUSTOMER
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
	
	@Column(name = "FEEDBACK")
    private String feedback;
	
	@Column(name = "RATING")
    private int rating;
	
	@Column(name = "SUBMIT_DATE")
    private LocalDate submitDate;
	//defining constructors
	public Feedback() {}

	public Feedback(int feedbackId, Customer customer, String feedback, int rating, LocalDate submitDate) {
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}

	
	public Feedback(String feedback, int rating, LocalDate submitDate) {
		super();
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}
	
	// Getters and setters
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}
	//ToString
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customer=" + customer + ", feedback=" + feedback + ", rating="
				+ rating + ", submitDate=" + submitDate + "]";
	}
	

}
