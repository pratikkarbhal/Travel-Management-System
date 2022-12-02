package com.tms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.tms.entities.Customer;

public class FeedbackDetails {

	private int feedbackId;
	private String feedback;
	private  int rating;
	private LocalDate submitDate;
	private int customerId;
	
	//Getters and Setters 
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	//Constructor
	public FeedbackDetails(int feedbackId,String feedback, int rating, LocalDate submitDate) {
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
	}
		
	
}
