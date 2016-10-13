package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.HospitalDto;

public interface IHospitalApi{
	
	HospitalDto create(HospitalDto hospitalDto);
	HospitalDto update(HospitalDto hospitalDto);
	boolean delete(long hospitalId);
	HospitalDto getHospital(long hospitalId);
	List<HospitalDto> getAllHospitals();
	HospitalDto getHospitalByName(String name);
}
