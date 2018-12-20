package com.example.countryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.countryservice.model.Country;
import com.example.countryservice.repository.CountryRepository;

@RestController
public class CountryController {

	@Autowired
	private CountryRepository repository;
	
	@GetMapping
	public List<Country> listAll() {
		return repository.findAll();
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
}
