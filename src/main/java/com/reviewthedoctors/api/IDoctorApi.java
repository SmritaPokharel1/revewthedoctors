package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.DoctorDto;

public interface IDoctorApi {
	
	DoctorDto create(DoctorDto doctorDto);
	DoctorDto update(DoctorDto doctorDto);
	boolean delete(long doctorId);
	DoctorDto getDoctor(long doctorId);
	List<DoctorDto> getAllDoctors();
	DoctorDto getDoctor(long doctorId,boolean isReviewListon);
	List<DoctorDto> searchDoctor(String searchQuery);
	DoctorDto getDoctorByName(String firstName,String lastName);
	

}
