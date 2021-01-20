package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.HouseDomain;
import com.qa.persistence.dto.HouseDTO;
import com.qa.persistence.repos.HouseRepo;
import com.qa.utils.MyBeanUtils;

@Service
public class HouseService {
	
	private HouseRepo repo;
	private ModelMapper mapper;
	
	@Autowired	
	public HouseService(HouseRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private HouseDTO mapToDTO(HouseDomain model) {
		return this.mapper.map(model, HouseDTO.class);
	}
	
	// CRUD
	// Create
	public HouseDTO create(HouseDomain model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read
	public HouseDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	public List<HouseDTO> readAll() {
		
		List<HouseDomain> catList = this.repo.findAll();
		List<HouseDTO> catListDTO = catList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return catListDTO;
	}
	
	// Update
	public HouseDTO update(long id, HouseDomain cat) {
		
		HouseDomain updatedCat = this.repo.findById(id).orElseThrow();
		MyBeanUtils.mergeNotNull(cat, updatedCat);
		
		return this.mapToDTO(this.repo.save(updatedCat));
	}
	
	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}

}
