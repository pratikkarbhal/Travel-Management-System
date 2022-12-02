package com.tms.service;

import java.util.List;

import com.tms.entities.Feedback;

public interface IFeedbackService {
	
	public Feedback addFeedback(Feedback feedback);
	public Feedback findByFeedbackId(int feedbackId);
	public Feedback findByCustomerId(int customerId);
	public List<Feedback> viewAllFeedbacks();
	
}
