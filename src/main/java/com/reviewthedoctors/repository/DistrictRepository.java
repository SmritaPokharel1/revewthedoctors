package com.reviewthedoctors.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.District;

public interface DistrictRepository extends CrudRepository<District, Serializable>{

	@Query("select d from District d where name=?1")
	District getDistrictByName(String district);
}
