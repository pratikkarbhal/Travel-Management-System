package com.tms.util;

import org.springframework.stereotype.Component;

import com.tms.dto.UserDetails;
import com.tms.entities.Customer;
import com.tms.entities.User;

@Component
public class UserUtil {
	
	public UserDetails toDetailsUser(User user)
	{
		UserDetails userDetails = new UserDetails(user.getUserId(),user.getUserType(),user.getPassword());
		if(user.getUserType().equalsIgnoreCase("customer"))
		{
			Customer cust = user.getCustomer();
			cust.setFeedbacks(null);
			userDetails.setCustomer(cust);
		}
		else {
			userDetails.setAdmin(user.getAdmin());
		}
		return userDetails;
	}

}
