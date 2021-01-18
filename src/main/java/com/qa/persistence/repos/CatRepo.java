package com.qa.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
	
	// CRUD
	
	// create
	// reads
	// updates
	// deletes
	
	// custom SQL queries

}
