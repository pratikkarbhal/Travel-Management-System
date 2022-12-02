package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Customer;
import com.tms.entities.Feedback;

import com.tms.repository.ICustomerRepository;
import com.tms.repository.IFeedbackRepository;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Autowired 
	private ICustomerRepository customerRepository;
	
	//used for adding Feedback
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback feed = feedbackRepository.save(feedback);
		return feed;
	}

	//used for finding feedback by feedback Id
	@Override
	public Feedback findByFeedbackId(int feedbackId) {
		Optional<Feedback> optional = feedbackRepository.findById(feedbackId);
        Feedback feed = optional.get();
		return feed;
	}

	//Used for finding Feedback using customer ID
	@Override
	public Feedback findByCustomerId(int customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.get();
        Feedback feedback = feedbackRepository.findFeedbackByCustomer(customer);
        return feedback;
	}
	//Used for viewing all Feedbacks
	@Override
	public List<Feedback> viewAllFeedbacks() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks;
	}


}
