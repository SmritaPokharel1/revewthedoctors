package com.reviewthedoctors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	////@Query("Select r from Review r  where  r.review like CONCAT('%',?1,'%')")
	// r.doctor.firstName like CONCAT('%',?1,'%') OR r.doctor.middleName like CONCAT('%',?1,'%') OR r.doctor.lastName like CONCAT('%',?1,'%')
	@Query("Select r from Review r join r.doctor.specialityList s where  r.review like CONCAT('%',?1,'%') OR r.doctor.firstName like CONCAT('%',?1,'%') OR r.doctor.middleName like CONCAT('%',?1,'%') OR r.doctor.lastName like CONCAT('%',?1,'%') OR s.specialityName like CONCAT('%',?1,'%')")
	List<Review> searchReview(String searchQuery);
	
	@Query("Select r from Review r where r.user.email=?1")
	List<Review> searchReviewByUserName(String userName);
	
	@Query("Select r from Review r order by createdDate desc")
	List<Review> getLatestReviewList();

}
