package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Travels;

@Repository
public interface ITravelRepository extends JpaRepository<Travels, Integer> {

}
