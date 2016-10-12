package com.reviewthedoctors.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Serializable>{
	
	@Query("select c from Country c where c.name=?1")
	Country getCountryByName(String countryName);
	
	

}
