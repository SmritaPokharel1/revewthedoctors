package com.reviewthedoctors.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.dto.DistrictDto;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.model.dto.DocumentDto;
import com.reviewthedoctors.model.dto.HospitalDto;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.dto.SpecialityDto;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.model.dto.ZoneDto;
import com.reviewthedoctors.model.entity.City;
import com.reviewthedoctors.model.entity.Country;
import com.reviewthedoctors.model.entity.District;
import com.reviewthedoctors.model.entity.Doctor;
import com.reviewthedoctors.model.entity.Document;
import com.reviewthedoctors.model.entity.Hospital;
import com.reviewthedoctors.model.entity.Review;
import com.reviewthedoctors.model.entity.Speciality;
import com.reviewthedoctors.model.entity.User;
import com.reviewthedoctors.model.entity.Zone;

/**
 * The <code>ConvertUtil<code> class helps in converting entities to data
 * transfer objects(DTOs) and viceversa. This class follows the following
 * <b>methods naming convention:</b>
 * <ul>
 * <li>convert[Entity]ToDto: Converts entity to corresponding DTO. For instance
 * convertDocumentToDto. The name convertDocumentToDocumentDto is not chosen to
 * make the methods' names shorter</li>
 * <li>convertDtoTo[Entity]: Converts a DTO to corresponding entity. For
 * instance convertDtoToDocument. The name convertDocumentDtoToDocumentDto is
 * not chosen to make the methods' names shorter</li>
 * 
 * @author awesomegirl
 * 
 * 
 */
public class ConvertUtil {

	// TODO WRITE JAVA DOCS
	public static DocumentDto convertDocumentToDto(Document document) {
		DocumentDto documentDto = new DocumentDto();
		if (document != null) {
			if (document.getDocumentId() > 0) {
				documentDto.setDocumentId(document.getDocumentId());
			}
			documentDto.setDocumentLocation(document.getDocumentLocation());
			documentDto.setDocumentType(document.getDocumentType());
			return documentDto;
		}
		return null;

	}

	// TODO WRITE JAVA DOCS
	public static Document convertDtoToDocument(DocumentDto documentDto) {
		Document document = new Document();

		document.setDocumentId(documentDto.getDocumentId());
		document.setDocumentLocation(documentDto.getDocumentLocation());
		document.setDocumentType(documentDto.getDocumentType());

		return document;
	}

	public static DoctorDto convertDoctorToDto(Doctor doctor) {
		if (doctor != null) {
			DoctorDto doctorDto = new DoctorDto();

			doctorDto.setDoctorId(doctor.getDoctorId());
			doctorDto.setFirstName(doctor.getFirstName());
			doctorDto.setMiddleName(doctor.getMiddleName());
			doctorDto.setLastName(doctor.getLastName());
			doctorDto.setCityName(doctor.getCity().getName());
			try {
				doctorDto.setSpeciality(convertSpecialityToDto(doctor.getSpecialityList().get(0)));
			} catch (Exception e) {
			}
			try {
				doctorDto.setHospital(convertHospitalToDto(doctor.getHospitalList().get(0)));
			} catch (Exception e) {

			}

			return doctorDto;
		} else {
			return null;
		}
	}

	@Transactional

	public static DoctorDto convertDoctorToDto(Doctor doctor, boolean isReviewListOn) {
		if (doctor != null) {
			DoctorDto doctorDto = new DoctorDto();

			doctorDto.setDoctorId(doctor.getDoctorId());
			doctorDto.setFirstName(doctor.getFirstName());
			doctorDto.setMiddleName(doctor.getMiddleName());
			doctorDto.setLastName(doctor.getLastName());
			doctorDto.setCityName(doctor.getCity().getName());
			try {
				doctorDto.setSpeciality(convertSpecialityToDto(doctor.getSpecialityList().get(0)));
			} catch (Exception e) {
			}
			try {
				doctorDto.setHospital(convertHospitalToDto(doctor.getHospitalList().get(0)));
			} catch (Exception e) {

			}
			if (isReviewListOn) {
				try {
					Hibernate.initialize(doctor.getReviewList());
					doctorDto.setReviewList(convertReviewListToDtoList(doctor.getReviewList()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return doctorDto;
		} else {
			return null;
		}
	}

	public static Doctor convertDtoToDoctor(DoctorDto doctorDto) {
		if (doctorDto != null) {
			Doctor doctor = new Doctor();

			doctor.setFirstName(doctorDto.getFirstName());
			doctor.setMiddleName(doctorDto.getMiddleName());
			doctor.setLastName(doctorDto.getLastName());

			return doctor;
		} else {
			return null;
		}
	}

	public static UserDto convertUserToDto(User user) {

		if (user != null) {
			UserDto userDto = new UserDto();

			// userDto.setDocumentList(user.getDocumentList());
			userDto.setEmail(user.getEmail());
			userDto.setFirstName(user.getFirstName());
			userDto.setMiddleName(user.getMiddleName());
			userDto.setLastName(user.getLastName());
			userDto.setPassword(user.getPassword());
			userDto.setUserId(user.getUserId());
			// userDto.setUserStatus(user.getUserStatus());
			userDto.setCity(convertCityToDto(user.getCity()));

			return userDto;
		} else {
			return null;
		}
	}

	public static List<UserDto> convertUserListToDtoList(List<User> userList) {
		List<UserDto> userDtoList = new ArrayList<UserDto>();

		for (User user : userList) {
			userDtoList.add(convertUserToDto(user));
		}
		return userDtoList;
	}

	public static User convertDtoToUser(UserDto userDto) {

		if (userDto != null) {
			User user = new User();

			user.setEmail(userDto.getEmail());
			user.setFirstName(userDto.getFirstName());
			user.setMiddleName(userDto.getMiddleName());
			user.setLastName(userDto.getLastName());
			user.setPassword(userDto.getPassword());
			user.setUserId(userDto.getUserId());
			user.setUserStatus(userDto.getUserStatus());
			if(userDto.getAuthority()==null){
				user.setAuthority(StringConstants.AUTHORITY_ROLE_USER);
			}else{
				user.setAuthority(userDto.getAuthority());
			}

			return user;
		} else {
			return null;
		}
	}

	public static ReviewDto convertReviewToDto(Review review) {

		if (review != null) {
			ReviewDto reviewDto = new ReviewDto();

			reviewDto.setDoctor(convertDoctorToDto(review.getDoctor()));
			reviewDto.setRating(review.getRating());
			reviewDto.setReview(review.getReview());
			reviewDto.setReviewId(review.getReviewId());

			reviewDto.setUser(convertUserToDto(review.getUser()));

			return reviewDto;
		} else {
			return null;
		}
	}

	public static ReviewDto convertSearchedReviewToDto(Review review, int length) {
		if (review != null) {
			ReviewDto reviewDto = new ReviewDto();

			reviewDto.setDoctor(convertDoctorToDto(review.getDoctor()));
			reviewDto.setRating(review.getRating());
			if (review.getReview().length() > length) {
				reviewDto.setReview(review.getReview().substring(0, length));
			} else {
				reviewDto.setReview(review.getReview());
			}
			reviewDto.setReviewId(review.getReviewId());

			reviewDto.setUser(convertUserToDto(review.getUser()));

			return reviewDto;
		} else {
			return null;
		}
	}

	public static List<ReviewDto> convertReviewListToDtoList(List<Review> reviewList) {
		List<ReviewDto> reviewDtoList = new ArrayList<ReviewDto>();

		for (Review review : reviewList) {
			reviewDtoList.add(convertReviewToDto(review));
		}

		return reviewDtoList;
	}

	public static Review convertDtoToReview(ReviewDto reviewDto) {
		if (reviewDto != null) {
			Review review = new Review();

			// review.setDoctor(convertDtoToDoctor(reviewDto.getDoctorDto()));
			review.setRating(reviewDto.getRating());
			review.setReview(reviewDto.getReview());
			// review.setReviewId(reviewDto.getReviewId());

			// review.setUser(convertDtoToUser(reviewDto.getUserDto()));

			return review;
		} else {
			return null;
		}
	}

	/*
	 * public static LocationDto convertLocationToDto(Location location){
	 * LocationDto locationDto = new LocationDto();
	 * 
	 * locationDto.setCity(location.getCity());
	 * locationDto.setDistrict(location.getDistrict());
	 * locationDto.setLocationId(location.getLocationId());
	 * 
	 * locationDto.setZone(location.getZone());
	 * 
	 * return locationDto; }
	 */

	/*
	 * public static Location convertDtoToLocation(LocationDto locationDto){
	 * Location location = new Location();
	 * 
	 * location.setCity(locationDto.getCity());
	 * location.setContinent(locationDto.getContinent());
	 * location.setCountryName(locationDto.getCountryName());
	 * location.setCreatedBy(locationDto.getCreatedBy());
	 * location.setCreatedDate(locationDto.getCreatedDate());
	 * location.setDistrict(locationDto.getDistrict());
	 * location.setLocationId(locationDto.getLocationId());
	 * location.setUpdatedBy(locationDto.getUpdatedBy());
	 * location.setUpdatedDate(locationDto.getUpdatedDate());
	 * location.setZone(locationDto.getZone());
	 * 
	 * return location; }
	 */

	public static SpecialityDto convertSpecialityToDto(Speciality speciality) {
		if (speciality != null) {
			SpecialityDto specialityDto = new SpecialityDto();

			specialityDto.setCategory(speciality.getCategory());
			specialityDto.setSpecialityId(speciality.getSpecialityId());
			specialityDto.setSpecialityName(speciality.getSpecialityName());

			return specialityDto;
		} else {
			return null;
		}
	}

	public static Speciality convertDtoToSpeciality(SpecialityDto specialityDto) {
		if (specialityDto != null) {
			Speciality speciality = new Speciality();

			speciality.setCategory(specialityDto.getCategory());
			speciality.setSpecialityName(specialityDto.getSpecialityName());

			return speciality;
		} else {
			return null;
		}
	}

	public static List<SpecialityDto> convertSpecialityToDtoList(List<Speciality> specialityList) {
		List<SpecialityDto> specialityDtoList = new ArrayList<SpecialityDto>();
		for (Speciality speciality : specialityList) {
			specialityDtoList.add(convertSpecialityToDto(speciality));
		}
		return specialityDtoList;
	}

	public static CountryDto convertCountryToDto(Country country) {

		if (country != null) {
			CountryDto countryDto = new CountryDto();

			try {
				countryDto.setCountryId(country.getCountryId());
				countryDto.setName(country.getName());
			} catch (Exception e) {

			}
			return countryDto;
		} else {
			return null;
		}
	}

	public static Country convertDtoToCountry(CountryDto countryDto) {
		if (countryDto != null) {
			Country country = new Country();

			country.setName(countryDto.getName());
			country.setCreatedDate(new Date());

			return country;
		} else {
			return null;
		}
	}

	public static List<CountryDto> convertCountryToDtoList(List<Country> countryList) {
		List<CountryDto> countryDtoList = new ArrayList<CountryDto>();
		for (Country country : countryList) {
			countryDtoList.add(convertCountryToDto(country));
		}
		return countryDtoList;
	}

	public static ZoneDto convertZoneToDto(Zone zone) {
		if (zone != null) {
			ZoneDto zoneDto = new ZoneDto();

			zoneDto.setCountry(zone.getCountry().getName());
			zoneDto.setName(zone.getName());
			zoneDto.setZoneId(zone.getZoneId());

			return zoneDto;
		} else {
			return null;
		}
	}

	public static List<ZoneDto> convertZoneToDtoList(List<Zone> zoneList) {
		List<ZoneDto> zoneDtoList = new ArrayList<ZoneDto>();
		for (Zone zone : zoneList) {
			zoneDtoList.add(convertZoneToDto(zone));
		}
		return zoneDtoList;
	}

	public static District convertDtoToDistrict(DistrictDto districtDto) {
		if (districtDto != null) {
			District district = new District();

			district.setName(districtDto.getName());

			return district;
		} else {
			return null;
		}
	}

	public static List<DistrictDto> convertDistrictToDtoList(List<District> districtList) {
		List<DistrictDto> districtDtoList = new ArrayList<DistrictDto>();

		for (District district : districtList) {
			districtDtoList.add(convertDistrictToDto(district));
		}

		return districtDtoList;
	}

	public static City convertDtoToCity(CityDto cityDto) {
		if (cityDto != null) {
			City city = new City();
			city.setName(cityDto.getName());
			return city;
		} else {
			return null;
		}
	}

	public static List<CityDto> convertCityToDtoList(List<City> cityList) {
		List<CityDto> cityDtoList = new ArrayList<CityDto>();
		for (City city : cityList) {
			cityDtoList.add(convertCityToDto(city));
		}
		return cityDtoList;
	}

	public static Zone convertDtoToZone(ZoneDto zoneDto, Country country) {
		if (zoneDto != null) {
			Zone zone = new Zone();
			zone.setName(zoneDto.getName());
			if (country != null) {
				zone.setCountry(country);
			}
			return zone;
		} else {
			return null;
		}
	}

	public static DistrictDto convertDistrictToDto(District district) {
		if (district != null) {
			DistrictDto districtDto = new DistrictDto();

			districtDto.setDistrictId(district.getDistrictId());
			districtDto.setName(district.getName());
			districtDto.setZone(district.getZone().getName());
			districtDto.setCountry(district.getZone().getCountry().getName());

			return districtDto;
		} else {
			return null;
		}
	}

	public static CityDto convertCityToDto(City city) {
		if (city != null) {
			CityDto cityDto = new CityDto();

			cityDto.setCityId(city.getCityId());
			cityDto.setDistrict(city.getDistrict().getName());
			cityDto.setName(city.getName());
			cityDto.setZone(city.getDistrict().getZone().getName());
			cityDto.setCountry(city.getDistrict().getZone().getCountry().getName());

			return cityDto;
		} else {
			return null;
		}
	}

	public static List<DocumentDto> convertDocumentToDtoList(List<Document> documentList) {
		List<DocumentDto> documentDtoList = new ArrayList<DocumentDto>();

		for (Document document : documentList) {
			documentDtoList.add(convertDocumentToDto(document));
		}

		return documentDtoList;
	}

	public static List<Document> convertDtoToDocumentList(List<DocumentDto> documentDtoList) {
		List<Document> documentList = new ArrayList<Document>();

		for (DocumentDto document : documentDtoList) {
			documentList.add(convertDtoToDocument(document));
		}

		return documentList;
	}

	public static HospitalDto convertHospitalToDto(Hospital hospital) {

		if (hospital != null) {
			HospitalDto hospitalDto = new HospitalDto();

			hospitalDto.setCity(convertCityToDto(hospital.getCity()));
			hospitalDto.setHospitalId(hospital.getHospitalId());
			hospitalDto.setHospitalType(hospital.getHospitalType());
			hospitalDto.setName(hospital.getName());

			return hospitalDto;
		} else {
			return null;
		}
	}

	public static Hospital convertDtoToHospital(HospitalDto hospitalDto) {
		if (hospitalDto != null) {
			Hospital hospital = new Hospital();
			hospital.setHospitalType(hospitalDto.getHospitalType());
			hospital.setName(hospitalDto.getName());
			return hospital;
		} else {
			return null;
		}
	}
}
