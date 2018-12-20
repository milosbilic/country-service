package com.example.countryservice.dto;

public class CityDto {

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
