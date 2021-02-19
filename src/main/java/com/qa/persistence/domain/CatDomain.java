package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	private String name;
	
	@NotNull
	private int age;
	private float speechVolume;
	
	@ManyToOne
	private HouseDomain house;

	public CatDomain(@NotNull String name, @NotNull int age, float speechVolume, HouseDomain house) {
		super();
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
		this.house = house;
	}
	
}
