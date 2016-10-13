package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.CountryDto;


public interface ICityApi {
	CityDto create(CityDto cityDto);
	CityDto update(CityDto cityDto);
	boolean delete(long cityid);
	CountryDto getCity(long cityId);
	List<CityDto> getAllCityList() ;
	CityDto getCityByName(String name);
}
