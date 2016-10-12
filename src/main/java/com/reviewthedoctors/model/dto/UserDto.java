package com.reviewthedoctors.model.dto;

import java.util.Date;
import java.util.List;
import com.reviewthedoctors.model.entity.Document;
import com.reviewthedoctors.model.entity.Review;

public class UserDto{
	
private long userId;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String userStatus;
	private CityDto city;
	private String cityName;
	private String authority;
	
	
	private List<DocumentDto> documentList;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public List<DocumentDto> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<DocumentDto> documentList) {
		this.documentList = documentList;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
