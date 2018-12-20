package com.example.countryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.countryservice.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
