package com.reviewthedoctors.model.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

public class ZoneDto {
	
	private long zoneId;
	private String name;
	private String country;
	
	public long getZoneId() {
		return zoneId;
	}
	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
