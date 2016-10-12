package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IUserApi;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.model.entity.City;
import com.reviewthedoctors.model.entity.User;
import com.reviewthedoctors.repository.CityRepository;
import com.reviewthedoctors.repository.UserRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class UserApi implements IUserApi{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	/*public UserApi(UserRepository userRepository,CityRepository cityRepository){
		this.userRepository=userRepository;
		this.cityRepository=cityRepository;
	}*/

	public UserDto create(UserDto userDto) {
		User user = ConvertUtil.convertDtoToUser(userDto);
		City city = cityRepository.getCityByName(userDto.getCityName());
		user.setCity(city);
		return ConvertUtil.convertUserToDto(userRepository.save(user));
	}
	
	public List<UserDto> getAllUser(){
		Iterable<User> userIterable = userRepository.findAll();
		List<User> userList = new ArrayList<User>();
		for(User user:userIterable){
			userList.add(user);
		}
		return ConvertUtil.convertUserListToDtoList(userList);
	}

	public UserDto update(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDto getDoctor(long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public UserDto getUserByEmail(String email){
		return ConvertUtil.convertUserToDto(userRepository.getByUserName(email));
	}

}
