package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tms.dto.FeedbackDetails;
import com.tms.entities.Customer;
import com.tms.entities.Feedback;

@Component
public class FeedbackUtil {
	public FeedbackDetails toDetailsFeedback(Feedback feed)
	{
		FeedbackDetails feedDetails = new FeedbackDetails(feed.getFeedbackId(),feed.getFeedback(),feed.getRating(),feed.getSubmitDate());
		Customer cust = feed.getCustomer();
		if(cust!=null)
		{
			feedDetails.setCustomerId(cust.getCustomerId());
		}
		return feedDetails;
	}
	
	public List<FeedbackDetails> toDetailsFeedback(Collection<Feedback> feedbacks) {
        List<FeedbackDetails> feedList = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            FeedbackDetails details = toDetailsFeedback(feedback);
            feedList.add(details);
        }
        return feedList;
	}
}
