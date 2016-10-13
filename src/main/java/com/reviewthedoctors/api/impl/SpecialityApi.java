package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.ISpecialityApi;
import com.reviewthedoctors.model.dto.SpecialityDto;
import com.reviewthedoctors.model.entity.Speciality;
import com.reviewthedoctors.repository.SpecialityRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class SpecialityApi implements ISpecialityApi {
	
	@Autowired
	private SpecialityRepository specialityRepository;
	
	public SpecialityDto create(SpecialityDto specialityDto) {
		Speciality speciality = ConvertUtil.convertDtoToSpeciality(specialityDto);
		return ConvertUtil.convertSpecialityToDto(specialityRepository.save(speciality));
		
	}

	public SpecialityDto update(SpecialityDto specialityDto) {
		return null;
	}

	public boolean delete(long specialityId) {
		// TODO Auto-generated method stub
		return false;
	}

	public SpecialityDto getSpeciality(long specialityId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SpecialityDto> getAllSpecialities(){
		Iterable<Speciality> specialityIterable = specialityRepository.findAll();
		List<SpecialityDto> specialityDtoList = new ArrayList<SpecialityDto>();
		for(Speciality speciality:specialityIterable){
			specialityDtoList.add(ConvertUtil.convertSpecialityToDto(speciality));
		}
		return specialityDtoList;
	}
	
	public SpecialityDto getSpecialityByName(String name){
		return ConvertUtil.convertSpecialityToDto(specialityRepository.getSpecialityByName(name));
	}

}
