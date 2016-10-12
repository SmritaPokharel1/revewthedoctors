package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.CountryDto;

public interface ICountryApi {

	CountryDto create(CountryDto countryDto);
	CountryDto update(CountryDto countryDto);
	boolean delete(long countryId);
	CountryDto getCountry(long countryId);
	List<CountryDto> getAllCountryList();
	CountryDto getCountryByName(String countryName);
	
	
}
