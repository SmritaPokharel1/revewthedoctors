package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.ICityApi;
import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.entity.City;
import com.reviewthedoctors.model.entity.District;
import com.reviewthedoctors.repository.CityRepository;
import com.reviewthedoctors.repository.DistrictRepository;
import com.reviewthedoctors.util.ConvertUtil;

/**
 * The class <code>CityApi</code> has methods to create, retrieve, update and delete either a city or cities.
 * @author SmritaPokharel
 *
 */
@Service
public class CityApi implements ICityApi{
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;

	/**
	 * Saves city entity to the database.
	 * @Param cityDto : the city entity that is to be persisted to the database.
	 */
	@Override
	public CityDto create(CityDto cityDto) {
		District district = districtRepository.getDistrictByName(cityDto.getDistrict());
		
		City city = ConvertUtil.convertDtoToCity(cityDto);
		city.setDistrict(district);
		
		return ConvertUtil.convertCityToDto(cityRepository.save(city));
	}

	
	@Override
	public CityDto update(CityDto cityDto) {
		return null;
	}

	@Override
	public boolean delete(long cityId) {
		return false;
	}

	@Override
	public CountryDto getCity(long cityId) {
		return null;
	}
	
	/**
	 * Retrieves all cities and returns a list of <code>CityDto</code>
	 * @return cityDtoList :a list of cities that are in the database
	 */
	@Override
	public List<CityDto> getAllCityList() {
		Iterable<City> cityIterable = cityRepository.findAll();
		List<CityDto> cityDtoList = new ArrayList<CityDto>();
		for (City city : cityIterable) {
			cityDtoList.add(ConvertUtil.convertCityToDto(city));
		}
		return cityDtoList;
		}
	
	/**
	 * Retrieves a city by its name and returns a CityDto
	 * @return cityDto retrieved from the city name. 
	 */
	@Override
	public CityDto getCityByName(String name){
		return ConvertUtil.convertCityToDto(cityRepository.getCityByName(name));
	}

}
