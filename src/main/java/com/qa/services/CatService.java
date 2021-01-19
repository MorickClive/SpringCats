package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.dto.CatDTO;
import com.qa.persistence.repos.CatRepo;
import com.qa.utils.MyBeanUtils;

@Service
public class CatService {
	
	private CatRepo repo;
	private ModelMapper mapper;
	
	@Autowired	
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
	
	// CRUD
	// Create
	public CatDTO create(CatDomain model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read
	public CatDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	public List<CatDTO> readAll() {
		
		List<CatDomain> catList = this.repo.findAll();
		List<CatDTO> catListDTO = catList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return catListDTO;
	}
	
	// Update
	public CatDTO update(long id, CatDomain cat) {
		
		CatDomain updatedCat = this.repo.findById(id).orElseThrow();
		MyBeanUtils.mergeNotNull(cat, updatedCat);
		
		return this.mapToDTO(this.repo.save(updatedCat));
	}
	
	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}

}
