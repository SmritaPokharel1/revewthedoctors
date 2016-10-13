package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IZoneApi;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.dto.ZoneDto;
import com.reviewthedoctors.model.entity.Country;
import com.reviewthedoctors.model.entity.Zone;
import com.reviewthedoctors.repository.CountryRepository;
import com.reviewthedoctors.repository.ZoneRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class ZoneApi implements IZoneApi{
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public ZoneDto create(ZoneDto zoneDto) {
		Country country = countryRepository.getCountryByName(zoneDto.getCountry());
		Zone zone = zoneRepository.save(ConvertUtil.convertDtoToZone(zoneDto, country));
		return ConvertUtil.convertZoneToDto(zone);
	}

	@Override
	public ZoneDto update(ZoneDto zoneDto) {
		return null;
	}

	@Override
	public boolean delete(long zoneId) {
		return false;
	}

	@Override
	public ZoneDto getZone(long zoneId) {
		return null;
	}
	
	@Override
	public List<ZoneDto> getAllZoneList() {
		Iterable<Zone> zoneIterable = zoneRepository.findAll();
		List<ZoneDto> zoneDtoList = new ArrayList<ZoneDto>();
		for (Zone zone : zoneIterable) {
			zoneDtoList.add(ConvertUtil.convertZoneToDto(zone));
		}
		return zoneDtoList;
	}
	
	@Override
	public ZoneDto getZoneByName(String zoneName){
		return ConvertUtil.convertZoneToDto(zoneRepository.getZoneByName(zoneName));
	}

}
