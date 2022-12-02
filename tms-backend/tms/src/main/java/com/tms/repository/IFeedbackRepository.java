package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Customer;
import com.tms.entities.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

	Feedback findFeedbackByCustomer(Customer customer);

}
