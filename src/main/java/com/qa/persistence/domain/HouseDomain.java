package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class HouseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	private String name;

	public HouseDomain(Long id, @NotNull String name) {
		super();
		Id = id;
		this.name = name;
	}

	public HouseDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HouseDomain [Id=" + Id + ", name=" + name + "]";
	}

}
