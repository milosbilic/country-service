package com.example.countryservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.countryservice.model.Country;
import com.example.countryservice.repository.CountryRepository;

@Component
public class Bootstrap {

	@Autowired
	private CountryRepository countryRepository;
	
	@PostConstruct
	public void initData() {
		Country serbia = new Country();
		serbia.setName("Serbia");
		
		Country italy = new Country();
		italy.setName("Italy");
		
		Country greece = new Country();
		greece.setName("Greece");
		
		countryRepository.save(serbia);
		countryRepository.save(italy);
		countryRepository.save(greece);
	}
	
}
