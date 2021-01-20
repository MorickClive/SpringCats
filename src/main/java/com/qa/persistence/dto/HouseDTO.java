package com.qa.persistence.dto;

public class HouseDTO {
	
	private Long Id;
	private String name;
	@Override
	public String toString() {
		return "HouseDTO [Id=" + Id + ", name=" + name + "]";
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
	public HouseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HouseDTO(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}
}
