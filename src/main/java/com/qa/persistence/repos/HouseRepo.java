package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.HouseDomain;

@Repository
public interface HouseRepo extends JpaRepository<HouseDomain, Long> {
	
	// CRUD
	
	// create
	// reads
	// updates
	// deletes
	
	// custom SQL queries

}
