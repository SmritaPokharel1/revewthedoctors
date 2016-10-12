package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.DistrictDto;

public interface IDistrictApi {

	DistrictDto create(DistrictDto districtDto);
	DistrictDto update(DistrictDto districtDto);
	boolean delete(long districtId);
	DistrictDto getDistrict(long districtId);
	List<DistrictDto> getAllDistrictList();
	DistrictDto getDistrictByName(String district);
	
}
