package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.UserDto;

public interface IUserApi{
	
	public UserDto create(UserDto userDto);
	public UserDto update(UserDto userDto);
	public boolean delete(long userId);
	public UserDto getUser(long userId);
	public List<UserDto> getAllUser();
	public UserDto getUserByEmail(String email);
	

}
