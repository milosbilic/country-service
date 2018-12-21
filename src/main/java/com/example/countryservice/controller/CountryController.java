package com.example.countryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.countryservice.client.CityClient;
import com.example.countryservice.dto.CityDto;
import com.example.countryservice.dto.CountryDto;
import com.example.countryservice.dto.converter.CountryToCountryDto;
import com.example.countryservice.model.Country;
import com.example.countryservice.repository.CountryRepository;

@RestController
public class CountryController {

	@Autowired
	private CountryRepository repository;
	
	@Autowired
	private CityClient cityClient;
	
	@Autowired
	private CountryToCountryDto toCountryDto;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping
	public List<Country> listAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}/with-cities")
	public CountryDto findByIdWithCities(@PathVariable Long id) {
		CountryDto retVal = toCountryDto.convert(repository.findById(id).get());
//		retVal.setCities(cityClient.findByCountry(id));
		
		List<CityDto> cities = (List<CityDto>) restTemplate.getForEntity(
				"https://city-service.herokuapp.com/country/" + id, List.class);
		retVal.setCities(cities);
		return retVal;
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
}
