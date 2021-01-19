package com.qa.persistence.dto;

public class CatDTO {
	private Long Id;
	private String name;
	private int age;
	private float speechVolume;
	
	// Constructors
	public CatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatDTO(Long id, String name, int age, float speechVolume) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}
	
	// Get/Set
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSpeechVolume() {
		return speechVolume;
	}
	public void setSpeechVolume(float speechVolume) {
		this.speechVolume = speechVolume;
	}
	@Override
	public String toString() {
		return "CatDTO [Id=" + Id + ", name=" + name + ", age=" + age + ", speechVolume=" + speechVolume + "]";
	}

}
