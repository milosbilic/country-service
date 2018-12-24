package com.example.countryservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.countryservice.dto.CityDto;

@FeignClient(name = "city-service")
public interface CityClient {

	@GetMapping("/country/{countryId}")
	List<CityDto> findByCountry(@PathVariable Long countryId);
	
}
