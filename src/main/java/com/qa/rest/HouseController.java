package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.HouseDomain;
import com.qa.persistence.dto.HouseDTO;
import com.qa.services.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {

	private HouseService service;

	@Autowired
	public HouseController(HouseService service) {
		super();
		this.service = service;
	}

	// GET, POST, PUT, DELETE

	// READ
	@GetMapping("/readAll")
	public ResponseEntity<List<HouseDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// READ
	@GetMapping("/read/{id}")
	public ResponseEntity<HouseDTO> read(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<HouseDTO> create(@RequestBody HouseDomain model) {
		return new ResponseEntity<HouseDTO>(this.service.create(model), HttpStatus.CREATED);
	}

	// Update
	@PutMapping("update/{id}")
	public ResponseEntity<HouseDTO> update(@PathVariable("id") Long id,  @RequestBody HouseDomain model) {
		return new ResponseEntity<>(this.service.update(id, model), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HouseDTO> delete(@PathVariable("id") Long id){
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
