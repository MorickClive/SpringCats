package com.qa.persistence.dto;

import java.util.List;

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.domain.HouseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
	
	private Long Id;
	private String name;
	private List<CatDTO> catlist;
}
