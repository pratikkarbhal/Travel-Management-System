package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}