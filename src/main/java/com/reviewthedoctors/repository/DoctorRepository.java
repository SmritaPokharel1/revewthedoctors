package com.reviewthedoctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Doctor;


public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	@Query("Select d from Doctor d join d.specialityList s where d.firstName like CONCAT('%',?1,'%') OR d.middleName like CONCAT('%',?1,'%') OR d.lastName like CONCAT('%',?1,'%') OR s.specialityName like CONCAT('%',?1,'%')")
	List<Doctor> searchDoctor(String searchQuery);
	
	@Query("Select d from Doctor d where firstName=?1 and lastName=?2")
	Doctor getDoctorByName(String firstName,String lastName);
		
	
}
