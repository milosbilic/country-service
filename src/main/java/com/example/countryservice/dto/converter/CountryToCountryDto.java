package com.example.countryservice.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.countryservice.dto.CountryDto;
import com.example.countryservice.model.Country;

@Component	
public class CountryToCountryDto implements Converter<Country, CountryDto> {

	@Override
	public CountryDto convert(Country c) {
		return new CountryDto(c.getId(), c.getName());
	}

}
