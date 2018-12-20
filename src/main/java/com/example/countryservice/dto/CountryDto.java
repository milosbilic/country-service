package com.example.countryservice.dto;

import java.util.List;

public class CountryDto {

	private Long id;
	private String name;
	private List<CityDto> cities;
	public CountryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CountryDto(Long id, String name, List<CityDto> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}
	public CountryDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
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
	public List<CityDto> getCities() {
		return cities;
	}
	public void setCities(List<CityDto> cities) {
		this.cities = cities;
	}
	
	
	
}
