package com.reviewthedoctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Hospital;


public interface HospitalRepository extends CrudRepository<Hospital, Long>{

	@Query("Select h from Hospital h where name=?1")
	Hospital getHospitalByName(String name);
	
	@Query("Select h from Hospital h where name in ?1")
	List<Hospital> getHospitalListByNameArray(String[] hospitalNameArray);
}
