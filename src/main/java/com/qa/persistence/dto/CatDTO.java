package com.qa.persistence.dto;

import com.qa.persistence.domain.CatDomain;
import com.qa.persistence.domain.HouseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatDTO {
	private Long Id;
	private String name;
	private int age;
	private float speechVolume;
	
}
