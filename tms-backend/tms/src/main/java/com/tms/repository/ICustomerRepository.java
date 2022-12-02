package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tms.entities.Customer;
import com.tms.entities.Package;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select booking.userId from Booking booking where booking.pack=:pack")
	public int findByPackage(@Param("pack") Package pack);

}
