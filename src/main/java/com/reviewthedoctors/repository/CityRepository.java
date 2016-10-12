package com.reviewthedoctors.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.City;

public interface CityRepository extends CrudRepository<City, Serializable> {

	@Query("select c from City c where name=?1")
	City getCityByName(String name);
}

