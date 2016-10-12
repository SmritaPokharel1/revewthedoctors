package com.reviewthedoctors.model.dto;

import com.reviewthedoctors.model.entity.City;

public class HospitalDto{
	
	
	private long hospitalId;
	private String name;
	private String hospitalType;	
	private CityDto city;
	private String cityName;
	
	public long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
