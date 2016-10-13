package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.ZoneDto;

public interface IZoneApi {
	
	ZoneDto create(ZoneDto zoneDto);
	ZoneDto update(ZoneDto zoneDto);
	boolean delete(long zoneId);
	ZoneDto getZone(long zoneId);
	List<ZoneDto> getAllZoneList();
	ZoneDto getZoneByName(String zoneName);
	
}
