package com.reviewthedoctors.api;

import com.reviewthedoctors.model.dto.BaseDto;

public interface IBaseApi {

	public BaseDto create(BaseDto baseDto);
	public BaseDto update(BaseDto baseDto);
	public boolean delete(BaseDto baseDto);
	public BaseDto getDoctor(long id);
	
}
