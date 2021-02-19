package com.qa.persistence.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HouseDTO {
	
	private Long Id;
	private String name;
	private List<CatDTO> catList;
}
