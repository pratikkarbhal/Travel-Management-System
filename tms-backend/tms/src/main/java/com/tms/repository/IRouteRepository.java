package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer> {

}