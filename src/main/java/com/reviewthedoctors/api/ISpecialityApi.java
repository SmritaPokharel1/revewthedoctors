package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.SpecialityDto;

public interface ISpecialityApi{
	
	SpecialityDto create(SpecialityDto specialityDto);
	SpecialityDto update(SpecialityDto specialityDto);
	boolean delete(long specialityId);
	SpecialityDto getDoctor(long specialityId);
	List<SpecialityDto> getAllSpecialities();
	SpecialityDto getSpecialityByName(String name);
	

}
