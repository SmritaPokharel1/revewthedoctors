package com.reviewthedoctors.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Zone;

public interface ZoneRepository extends CrudRepository<Zone, Serializable>{
	
	@Query("select z from Zone z where name=?1")
	Zone getZoneByName(String name);
}
