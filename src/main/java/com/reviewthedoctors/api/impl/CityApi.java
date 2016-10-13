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

@Service
public class CityApi implements ICityApi{
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;

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
	
	@Override
	public List<CityDto> getAllCityList() {
		Iterable<City> cityIterable = cityRepository.findAll();
		List<CityDto> cityDtoList = new ArrayList<CityDto>();
		for (City city : cityIterable) {
			cityDtoList.add(ConvertUtil.convertCityToDto(city));
		}
		return cityDtoList;
		}
	
	@Override
	public CityDto getCityByName(String name){
		return ConvertUtil.convertCityToDto(cityRepository.getCityByName(name));
	}

}
