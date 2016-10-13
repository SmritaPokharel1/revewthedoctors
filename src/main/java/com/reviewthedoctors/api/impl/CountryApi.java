package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.ICountryApi;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.entity.Country;
import com.reviewthedoctors.repository.CountryRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class CountryApi implements ICountryApi {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public CountryDto create(CountryDto countryDto) {
		Country country = countryRepository.save(ConvertUtil.convertDtoToCountry(countryDto));
		return ConvertUtil.convertCountryToDto(country);
	}

	@Override
	public CountryDto update(CountryDto countryDto) {
		return null;
	}

	@Override
	public boolean delete(long countryId) {
		try {
			countryRepository.delete(countryId);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	@Override
	public CountryDto getCountry(long countryId) {
		return null;
	}

	@Override
	public List<CountryDto> getAllCountryList() {
		Iterable<Country> countryIterable = countryRepository.findAll();
		List<CountryDto> countryDtoList = new ArrayList<CountryDto>();
		for (Country country : countryIterable) {
			countryDtoList.add(ConvertUtil.convertCountryToDto(country));
		}
		return countryDtoList;
	}
	
	@Override
	public CountryDto getCountryByName(String countryName){
		return ConvertUtil.convertCountryToDto(countryRepository.getCountryByName(countryName));
	}

}
