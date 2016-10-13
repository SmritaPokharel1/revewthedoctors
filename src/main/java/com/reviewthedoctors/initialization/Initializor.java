package com.reviewthedoctors.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.reviewthedoctors.api.ICityApi;
import com.reviewthedoctors.api.ICountryApi;
import com.reviewthedoctors.api.IDistrictApi;
import com.reviewthedoctors.api.IDoctorApi;
import com.reviewthedoctors.api.IHospitalApi;
import com.reviewthedoctors.api.ISpecialityApi;
import com.reviewthedoctors.api.IUserApi;
import com.reviewthedoctors.api.IZoneApi;
import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.dto.DistrictDto;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.model.dto.HospitalDto;
import com.reviewthedoctors.model.dto.SpecialityDto;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.model.dto.ZoneDto;
import com.reviewthedoctors.util.StringConstants;

/**
 * The class <code>Initializor</code> populates startup data in the database.
 * Following are the tables where data is populated when the application starts:
 * <ol>
 * 		<li>Country</li>
 * 	    <li>Zone</li>
 *      <li>District</li>
 *      <li>City</li>
 *      <li>User</li>
 *      <li>Doctor</li>
 *      <li>Specialty</li>
 *      <li>Review</li>
 * </ol>
 * @author SmritaPokharel
 *
 */
public class Initializor {
	
	@Autowired
	private IUserApi userApi;
	
	@Autowired
	private ICountryApi countryApi;
	
	@Autowired
	private IZoneApi zoneApi;
	
	@Autowired
	private IDistrictApi districtApi;
	
	@Autowired
	private ICityApi cityApi;
	
	@Autowired
	private IDoctorApi doctorApi;
	
	@Autowired
	private ISpecialityApi specialityApi;
	
	@Autowired
	private IHospitalApi hospitalApi;
	
	public UserDto getUserDto(String cityName,String firstName,String middleName,String lastName,String email,String password,String authority){
		UserDto userDto = new UserDto();
		
		userDto.setCityName(cityName);
		userDto.setFirstName(firstName);
		userDto.setMiddleName(middleName);
		userDto.setLastName(lastName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setAuthority(authority);
		return userDto;
	}
	
	/**
	 * Creates an admin and a user
	 * One user and one admin is added.
	 * <pre>
	 * Admin with following detail is added.
	 * Name: admin admin admin
	 * Email:'admin@gmail.com'
	 * Password 'test'
	 * authority ADMIN_ROLE
	 * 
	 * User with following detail is added.
	 * Name: Srija Pokharel
	 * Email:'srijapokharel@gmail.com'
	 * Password 'test'
	 * authority User_ROLE
	 * </pre>
	 */
	public void createUsers(){
		
		UserDto adminInDb = userApi.getUserByEmail(StringConstants.INIT_ADMIN_EMAIL);
		UserDto userInDb = userApi.getUserByEmail(StringConstants.INIT_USER_EMAIL);
		if(adminInDb==null){
			UserDto admin = getUserDto(StringConstants.INIT_CITY_NAME,StringConstants.INIT_ADMIN_NAME,StringConstants.INIT_ADMIN_NAME,StringConstants.INIT_ADMIN_NAME,StringConstants.INIT_ADMIN_EMAIL,StringConstants.INIT_PASSWORD,StringConstants.AUTHORITY_ROLE_ADMIN);
			userApi.create(admin);
		}
		if(userInDb==null){
			UserDto user = getUserDto(StringConstants.INIT_CITY_NAME,StringConstants.INIT_USER_FIRSTNAME,"",StringConstants.INIT_USER_LASTNAME,StringConstants.INIT_USER_EMAIL,StringConstants.INIT_PASSWORD,StringConstants.AUTHORITY_ROLE_USER);
			userApi.create(user);
		}
		
		
	}
	
	public CountryDto getCountryDto(String countryName){
		CountryDto countryDto = new CountryDto();
		countryDto.setName(countryName);
		return countryDto;
		
	}
	/**
	 * Creates a country named Nepal.
	 */
	public void createCountry(){
		CountryDto countryInDb = countryApi.getCountryByName(StringConstants.INIT_COUNTRY_NAME);
		if(countryInDb==null){
			CountryDto countryDto = getCountryDto(StringConstants.INIT_COUNTRY_NAME);
			countryApi.create(countryDto);
		}
	}
	
	public ZoneDto getZoneDto(String name,String countryName){
		ZoneDto zoneDto = new ZoneDto();
		
		zoneDto.setCountry(countryName);
		zoneDto.setName(name);
		
		return zoneDto;
		
	}
	
	/**
	 * Creates a Zone and saves it in the database.Zone with following detail is created
	 * <pre>
	 *     name: Bagmati
	 *     country:Nepal
	 * </pre>
	 */
	public void createZone(){
		ZoneDto zoneInDb = zoneApi.getZoneByName(StringConstants.INIT_ZONE_NAME);
		if(zoneInDb==null){
			ZoneDto zoneDto = getZoneDto(StringConstants.INIT_ZONE_NAME,StringConstants.INIT_COUNTRY_NAME);
			zoneApi.create(zoneDto);
		}
	}
	
	public DistrictDto getDistrictDto(String districtName,String zone){
		DistrictDto districtDto = new DistrictDto();
		
		districtDto.setZone(zone);
		districtDto.setName(districtName);
		
		return districtDto;
		
	}
	
	/**
	 * Creates a district and saves it in the database. District with the following detail is created:
	 * <pre>
	 * 	name:Kathmandu
	 *  Zone:Bagmati
	 * </pre>
	 */
	public void createDistrict(){
		DistrictDto districtInDb = districtApi.getDistrictByName(StringConstants.INIT_DISTRICT_NAME);
		if(districtInDb == null){
			DistrictDto districtDto = getDistrictDto(StringConstants.INIT_DISTRICT_NAME,StringConstants.INIT_ZONE_NAME);
			districtApi.create(districtDto);
		}
	}
	
	public CityDto getCityDto(String cityName,String districtName){
		CityDto cityDto = new CityDto();
		
		cityDto.setDistrict(districtName);
		cityDto.setName(cityName);
		
		return cityDto;
	}
	
	/**
	 * Creates a city and saves it in the database. City with the following detail is created:
	 * <pre>
	 * 	name:Kathmandu
	 *  District:Kathmandu
	 * </pre>
	 */
	public void createCity(){
		CityDto cityInDb = cityApi.getCityByName(StringConstants.INIT_CITY_NAME);
		if(cityInDb ==null){
			CityDto cityDto = getCityDto(StringConstants.INIT_CITY_NAME,StringConstants.INIT_DISTRICT_NAME);
			cityApi.create(cityDto);
		}
	}
	
	public DoctorDto getDoctorDto(String firstName,String middleName,String lastName,String city,String[] specialityNameArray,String[] hospitalNameArray){
		DoctorDto doctorDto = new DoctorDto();
		
		doctorDto.setCityName(city);
		doctorDto.setFirstName(firstName);
		doctorDto.setMiddleName(middleName);
		doctorDto.setLastName(lastName);
		doctorDto.setSpecialityNameArray(specialityNameArray);
		doctorDto.setHospitalNameArray(hospitalNameArray);
		
		return doctorDto;
	}
	/**
	 * Creates a doctor and saves it in the database. Doctor with the following detail is created:
	 * <pre>
	 *  FirstName:Arjun
	 *  MiddleName:Kumar
	 *  LastName:Karki
	 *  SpecialtyName:Pulmonologist
	 *  Hospital:Grande International Hospital
	 *  Zone:Bagmati
	 * </pre>
	 */
	public void createDoctor(){
		DoctorDto doctorInDb = doctorApi.getDoctorByName(StringConstants.INIT_DOCTOR_FIRSTNAME, StringConstants.INIT_DOCTOR_LASTNAME);
		String[] specialityNameArray= new String[1];
		specialityNameArray[0]=StringConstants.INIT_SPECIALITY_NAME;
		
		String[] hospitalNameArray = new String[1];
		hospitalNameArray[0] =StringConstants.INIT_HOSPITAL_NAME;
		
		if(doctorInDb==null){
			DoctorDto doctorDto = getDoctorDto(StringConstants.INIT_DOCTOR_FIRSTNAME,StringConstants.INIT_DOCTOR_MIDDLENAME,StringConstants.INIT_DOCTOR_LASTNAME,StringConstants.INIT_CITY_NAME,specialityNameArray,hospitalNameArray);
			doctorApi.create(doctorDto);
		}
	}
	
	public SpecialityDto getSpecialityDto(String specialityName,String category){
		SpecialityDto specialityDto = new SpecialityDto();
		
		specialityDto.setCategory(category);
		specialityDto.setSpecialityName(specialityName);
		
		return specialityDto;
	}
	
	public void createSpeciality(){
		SpecialityDto specialityInDb = specialityApi.getSpecialityByName(StringConstants.INIT_SPECIALITY_NAME);
		if(specialityInDb==null){
			SpecialityDto specialityDto = getSpecialityDto(StringConstants.INIT_SPECIALITY_NAME, StringConstants.INIT_SPECIALITY_CATEGORY);
			specialityApi.create(specialityDto);
		}
	}
	
	public HospitalDto getHospitalDto(String hospitalName,String hospitalType,String cityName){
		HospitalDto hospitalDto = new HospitalDto();
		
		hospitalDto.setCityName(cityName);
		hospitalDto.setHospitalType(hospitalType);
		hospitalDto.setName(hospitalName);
		
		return hospitalDto;
	}
	
	public void createHospital(){
		HospitalDto hospitalInDb = hospitalApi.getHospitalByName(StringConstants.INIT_HOSPITAL_NAME);
		if(hospitalInDb==null){
			HospitalDto hospitalDto = getHospitalDto(StringConstants.INIT_HOSPITAL_NAME,StringConstants.INIT_HOSPITAL_TYPE,StringConstants.INIT_CITY_NAME);
			hospitalApi.create(hospitalDto);
		}
	}
	
	@Transactional
	public void init(){
		createCountry();
		createZone();
		createDistrict();
		createCity();
		createUsers();
		createSpeciality();
		createHospital();
		createDoctor();
	}
	
}
