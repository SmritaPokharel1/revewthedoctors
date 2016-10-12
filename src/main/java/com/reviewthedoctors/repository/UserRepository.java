package com.reviewthedoctors.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.User;
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("Select u from User u where email=?1")
	User getByUserName(String userName);
	

}
