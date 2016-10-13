package com.reviewthedoctors.api;

import com.reviewthedoctors.model.dto.BaseDto;

public interface IBaseApi {

	BaseDto create(BaseDto baseDto);
	BaseDto update(BaseDto baseDto);
	boolean delete(BaseDto baseDto);
	BaseDto getEntity(long id);
	
}
