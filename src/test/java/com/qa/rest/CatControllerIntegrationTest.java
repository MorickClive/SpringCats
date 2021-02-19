package com.qa.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.dto.CatDTO;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql", "classpath:data-test.sql"}, 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("reg")
public class CatControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	// Test Utility
	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
	
	@Test
	public void create() throws Exception {
		// RESOURCES
		CatDomain testDomain = new CatDomain("Ravvi", 16, 11.4f, null);
		CatDTO testDTO = mapToDTO(testDomain);
		testDTO.setId(7L);
		
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders
				.request(HttpMethod.POST, "/cat/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.jsonifier.writeValueAsString(testDomain))
				.accept(MediaType.APPLICATION_JSON);
		
		// ASSERTION
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contents = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(testDTO));
		
		// ACTION
		mock.perform(mockRequest)
		.andExpect(status)
		.andExpect(contents);
	}

}
