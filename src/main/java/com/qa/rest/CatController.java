package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Cat;

@RestController
@RequestMapping("/cat")
public class CatController {
	
	private Long Id = 0L;	
	private List<Cat> listCat = new ArrayList<>();
	
	// GET, POST, PUT, DELETE
	@GetMapping("/greetings")
	public  String helloWorld(){
		return "Hello World!";		
	}
	
	@GetMapping("/readAll")
	public List<Cat> readAll(){
		return listCat;		
	}
	
	@GetMapping("/read/{id}")
	public Cat readCat(@PathVariable("id") Long id){
		return listCat.get(id.intValue());		
	}
	
	@PostMapping("/create")
	public boolean create(@RequestBody Cat cat) {
		// auto-increment
		cat.setId(Id);
		Id++;
		
		// add cat instance
		return listCat.add(cat);
	}
	
	//@PutMapping("update/{id}")
	
	//@DeleteMapping()
}
