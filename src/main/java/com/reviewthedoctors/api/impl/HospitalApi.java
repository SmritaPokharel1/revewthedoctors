package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IHospitalApi;
import com.reviewthedoctors.model.dto.HospitalDto;
import com.reviewthedoctors.model.entity.City;
import com.reviewthedoctors.model.entity.Hospital;
import com.reviewthedoctors.repository.CityRepository;
import com.reviewthedoctors.repository.HospitalRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class HospitalApi implements IHospitalApi{
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
/*	public HospitalApi(HospitalRepository hospitalRepository,CityRepository cityRepository){
		this.hospitalRepository=hospitalRepository;
		this.cityRepository=cityRepository;
	}*/

	public HospitalDto create(HospitalDto hospitalDto) {
		Hospital hospital = ConvertUtil.convertDtoToHospital(hospitalDto);
		City city = cityRepository.getCityByName(hospitalDto.getCityName());
		hospital.setCity(city);
		return ConvertUtil.convertHospitalToDto(hospitalRepository.save(hospital));
	}

	public HospitalDto update(HospitalDto hospitalDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(long hospitalId) {
		// TODO Auto-generated method stub
		return false;
	}

	public HospitalDto getDoctor(long hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<HospitalDto> getAllHospitals(){
		Iterable<Hospital> hospitalList = hospitalRepository.findAll();
		List<HospitalDto> hospitalDtoList = new ArrayList<HospitalDto>();
		for(Hospital hospital:hospitalList){
			hospitalDtoList.add(ConvertUtil.convertHospitalToDto(hospital));
		}
		
		return hospitalDtoList;
	}
	
	public HospitalDto getHospitalByName(String name){
		return ConvertUtil.convertHospitalToDto(hospitalRepository.getHospitalByName(name));
	}

}
