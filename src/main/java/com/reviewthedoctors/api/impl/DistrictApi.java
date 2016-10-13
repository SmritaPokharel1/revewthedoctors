package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IDistrictApi;
import com.reviewthedoctors.model.dto.DistrictDto;
import com.reviewthedoctors.model.entity.District;
import com.reviewthedoctors.model.entity.Zone;
import com.reviewthedoctors.repository.DistrictRepository;
import com.reviewthedoctors.repository.ZoneRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class DistrictApi implements IDistrictApi{
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	@Override
	public DistrictDto create(DistrictDto districtDto) {
		Zone zone = zoneRepository.getZoneByName(districtDto.getZone());
		District district = ConvertUtil.convertDtoToDistrict(districtDto);
		district.setZone(zone);
		return ConvertUtil.convertDistrictToDto(districtRepository.save(district));
	}

	@Override
	public DistrictDto update(DistrictDto districtDto) {
		return null;
	}

	@Override
	public boolean delete(long districtId) {
		return false;
	}

	@Override
	public DistrictDto getDistrict(long districtId) {
		return null;
	}

	@Override
	public List<DistrictDto> getAllDistrictList() {
		Iterable<District> districtIterable = districtRepository.findAll();
		List<DistrictDto> districtDtoList = new ArrayList<DistrictDto>();
		for (District district : districtIterable) {
			districtDtoList.add(ConvertUtil.convertDistrictToDto(district));
		}
		return districtDtoList;
	}
	
	@Override
	public DistrictDto getDistrictByName(String district){
		return ConvertUtil.convertDistrictToDto(districtRepository.getDistrictByName(district));
	}
}
