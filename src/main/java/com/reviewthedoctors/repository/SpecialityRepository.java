package com.reviewthedoctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Speciality;


public interface SpecialityRepository extends CrudRepository<Speciality, Long>{
	
	@Query("Select s from Speciality s where specialityName=?1")
	Speciality getSpecialityByName(String name);
	
	@Query("Select s from Speciality s where specialityName in ?1")
	List<Speciality> getSpecialityListByNameArray(String[] specialityArray);

}
