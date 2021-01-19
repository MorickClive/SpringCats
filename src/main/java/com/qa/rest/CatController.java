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

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.dto.CatDTO;
import com.qa.services.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	private CatService service;

	@Autowired
	public CatController(CatService service) {
		super();
		this.service = service;
	}

	// GET, POST, PUT, DELETE

	// READ
	@GetMapping("/readAll")
	public ResponseEntity<List<CatDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// READ
	@GetMapping("/read/{id}")
	public ResponseEntity<CatDTO> readCat(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<CatDTO> create(@RequestBody CatDomain cat) {
		return new ResponseEntity<CatDTO>(this.service.create(cat), HttpStatus.CREATED);
	}

	// Update
	@PutMapping("update/{id}")
	public ResponseEntity<CatDTO> update(@PathVariable("id") Long id,  @RequestBody CatDomain cat) {
		return new ResponseEntity<>(this.service.update(id, cat), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CatDTO> deleteCat(@PathVariable("id") Long id){
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
