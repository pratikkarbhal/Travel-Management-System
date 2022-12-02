package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

}