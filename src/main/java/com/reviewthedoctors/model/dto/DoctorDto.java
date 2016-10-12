package com.reviewthedoctors.model.dto;

import java.util.List;

public class DoctorDto{

	private long doctorId;
	private String firstName;
	private String middleName;
	private String lastName;
	private CityDto city;
	private SpecialityDto speciality;
	private HospitalDto hospital;
	private String cityName;
	private List<ReviewDto> reviewList;
	private String[] specialityNameArray;
	private String[] hospitalNameArray;
	
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public SpecialityDto getSpeciality() {
		return speciality;
	}
	public void setSpeciality(SpecialityDto speciality) {
		this.speciality = speciality;
	}
	public HospitalDto getHospital() {
		return hospital;
	}
	public void setHospital(HospitalDto hospital) {
		this.hospital = hospital;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String[] getSpecialityNameArray() {
		return specialityNameArray;
	}
	public void setSpecialityNameArray(String[] specialityNameArray) {
		this.specialityNameArray = specialityNameArray;
	}
	public String[] getHospitalNameArray() {
		return hospitalNameArray;
	}
	public void setHospitalNameArray(String[] hospitalNameArray) {
		this.hospitalNameArray = hospitalNameArray;
	}
	public List<ReviewDto> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<ReviewDto> reviewList) {
		this.reviewList = reviewList;
	}
	
}
