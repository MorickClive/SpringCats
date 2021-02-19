package com.qa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistence.domain.HouseDomain;
import com.qa.persistence.dto.HouseDTO;
import com.qa.persistence.repos.HouseRepo;

@SpringBootTest
public class HouseServiceUnitTest {

	@MockBean // same as @Mock
	private HouseRepo mockRepo;
	@MockBean // same as @Mock
	private ModelMapper mockMapper;

	@Autowired // same as @InjectMocks
	private HouseService service;
	
	HouseDomain testModel = new HouseDomain(1L, "121 Green Drive", new ArrayList<>());
	HouseDTO testDTO = mapToDTO(testModel);
	
	// our test mapper
	private static final ModelMapper testMapper = new ModelMapper();
	
	private HouseDTO mapToDTO(HouseDomain model) {
		return this.testMapper.map(model, HouseDTO.class);
	}

	// Create
	@Test
	public void createTest() {
		// RESOURCES
		HouseDomain testModel = new HouseDomain(1L, "121 Green Drive", new ArrayList<>());
		HouseDTO testDTO = mapToDTO(testModel);
		
		// RULES
		Mockito.when(mockRepo.save(testModel)).thenReturn(testModel);
		Mockito.when(mockMapper.map(testModel, HouseDTO.class) ).thenReturn(testDTO);
		
		// ACTIONS
		HouseDTO result = service.create(testModel);
		
		// ASSERTIONS
		assertEquals(testDTO, result);
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).save(testModel); // Mockito.any(HouseDomain.class)
		Mockito.verify(this.mockMapper, Mockito.times(1)).map(testModel, HouseDTO.class);
	}

	// Read
	@Test
	@Disabled
	public void readOne() {
	}

	@Test
	@Disabled
	public void readAll() {
	}

	// Update
	@Test
	@Disabled
	public void update() {
	}

	// Delete
	@Test
	@Disabled
	public void delete() {
	}

}
