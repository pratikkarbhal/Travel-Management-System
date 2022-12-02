package com.tms.repository;

import com.tms.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {
	
}
