package com.example.countryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	
	private static final String APPLICATION_JSON = "application/json";
	
	@GetMapping(produces = APPLICATION_JSON)
	public List<Country> listAll() {
		return repository.findAll();
	}
	
	@GetMapping(value= "/{id}/with-cities", produces = APPLICATION_JSON)
	public CountryDto findByIdWithCities(@PathVariable Long id) {
		CountryDto retVal = toCountryDto.convert(repository.findById(id).get());
//		retVal.setCities(cityClient.findByCountry(id));
		
//		List<CityDto> cities = (List<CityDto>) restTemplate.getForEntity(
//				"https://city-service.herokuapp.com/country/" + id, List.class);
		
		ResponseEntity<List<CityDto>> response = restTemplate.exchange(
				"https://city-service.herokuapp.com/country/" + id,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<CityDto>>(){});
		retVal.setCities(response.getBody());
		return retVal;
	}
	
	@GetMapping(value = "/test", produces = APPLICATION_JSON)
	public String test() {
		return "hello";
	}
	
}
