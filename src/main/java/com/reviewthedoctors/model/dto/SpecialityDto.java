package com.reviewthedoctors.model.dto;

public class SpecialityDto{
	
	private long specialityId;
	private String specialityName;
	private String category;
	
	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(long specialityId) {
		this.specialityId = specialityId;
	}

}
