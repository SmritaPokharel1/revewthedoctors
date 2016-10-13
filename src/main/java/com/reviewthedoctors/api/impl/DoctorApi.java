package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewthedoctors.api.IDoctorApi;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.entity.City;
import com.reviewthedoctors.model.entity.Doctor;
import com.reviewthedoctors.model.entity.Hospital;
import com.reviewthedoctors.model.entity.Speciality;
import com.reviewthedoctors.repository.CityRepository;
import com.reviewthedoctors.repository.DoctorRepository;
import com.reviewthedoctors.repository.HospitalRepository;
import com.reviewthedoctors.repository.SpecialityRepository;
import com.reviewthedoctors.util.ConvertUtil;

/**
 * 
 * @author awesomegirl
 *
 */
@Service
public class DoctorApi implements IDoctorApi{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private SpecialityRepository specialityRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public DoctorDto create(DoctorDto doctorDto) {
		List<Hospital> hospitalList = hospitalRepository.getHospitalListByNameArray(doctorDto.getHospitalNameArray());
		City city = cityRepository.getCityByName(doctorDto.getCityName());
		List<Speciality> specialityList = specialityRepository.getSpecialityListByNameArray(doctorDto.getSpecialityNameArray());
		Doctor doctor = ConvertUtil.convertDtoToDoctor(doctorDto);
		doctor.setSpecialityList(specialityList);
		doctor.setHospitalList(hospitalList);
		doctor.setCity(city);
		return ConvertUtil.convertDoctorToDto(doctorRepository.save(doctor));
	}

	public DoctorDto update(DoctorDto doctorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(long doctorId) {
		return false;
	}

	public DoctorDto getDoctor(long doctorId) {
		Doctor doctor = doctorRepository.findOne(doctorId);
		
		DoctorDto doctorDto = ConvertUtil.convertDoctorToDto(doctor);
		doctor.getReviewList().size();
		List<ReviewDto> reviewList = ConvertUtil.convertReviewListToDtoList(doctor.getReviewList());
		doctorDto.setReviewList(reviewList);
		
		return doctorDto;
		
	}
	
	@Transactional
	public DoctorDto getDoctor(long doctorId,boolean isReviewListon) {
		Doctor doctor = doctorRepository.findOne(doctorId);
		
		DoctorDto doctorDto = ConvertUtil.convertDoctorToDto(doctor,isReviewListon);
		
		return doctorDto;
		
	}

	public List<DoctorDto> getAllDoctors(){
		Iterable<Doctor> doctorIterable = doctorRepository.findAll();
		List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();
		for(Doctor doctor:doctorIterable){
			doctorDtoList.add(ConvertUtil.convertDoctorToDto(doctor));
		}
		
		return doctorDtoList;
	}
	
	public List<DoctorDto> searchDoctor(String searchQuery){
		List<Doctor> doctorIterable = doctorRepository.searchDoctor(searchQuery);
		List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();
		for(Doctor doctor:doctorIterable){
			doctorDtoList.add(ConvertUtil.convertDoctorToDto(doctor));
		}
		
		return doctorDtoList;
	}
	
	public DoctorDto getDoctorByName(String firstName,String lastName){
		return ConvertUtil.convertDoctorToDto(doctorRepository.getDoctorByName(firstName, lastName));
		
	}


}
