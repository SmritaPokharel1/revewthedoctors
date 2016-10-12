package com.reviewthedoctors.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IReviewApi;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.entity.Doctor;
import com.reviewthedoctors.model.entity.Review;
import com.reviewthedoctors.model.entity.User;
import com.reviewthedoctors.repository.DoctorRepository;
import com.reviewthedoctors.repository.ReviewRepository;
import com.reviewthedoctors.repository.UserRepository;
import com.reviewthedoctors.util.ConvertUtil;

@Service
public class ReviewApi implements IReviewApi {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/*public ReviewApi(ReviewRepository reviewRepository,DoctorRepository doctorRepository,UserRepository userRepository){
		this.reviewRepository=reviewRepository;
		this.doctorRepository=doctorRepository;
		this.userRepository=userRepository;
	}
	*/
	public ReviewDto create(ReviewDto reviewDto) {
		Doctor doctor = doctorRepository.findOne(reviewDto.getDoctorId());
		User user ; 
		if(reviewDto.getUser()!=null){
			user =  userRepository.getByUserName((reviewDto.getUser().getEmail()));
		}else{
			user = userRepository.findOne(reviewDto.getUserId());
		}
		Review review = ConvertUtil.convertDtoToReview(reviewDto);
		review.setCreatedDate(new Date());
		review.setUser(user);
		review.setDoctor(doctor);
		return ConvertUtil.convertReviewToDto(reviewRepository.save(review));
	}

	public ReviewDto update(ReviewDto reviewDto) {
		return null;
	}

	public boolean delete(long reviewId) {
		return false;
	}

	public ReviewDto getReview(long reviewId) {
		return ConvertUtil.convertReviewToDto(reviewRepository.findOne(reviewId));
	}
	
	public List<ReviewDto> getAllReviews(){
		Iterable<Review> reviewIterable = reviewRepository.findAll();
		List<ReviewDto> reviewDtoList = new ArrayList<ReviewDto>();
		for(Review review:reviewIterable){
			reviewDtoList.add(ConvertUtil.convertSearchedReviewToDto(review,50));
		}
		return reviewDtoList;		
	}
	
	public List<ReviewDto> searchReview(String searchQuery){
		List<Review> reviewIterable = reviewRepository.searchReview(searchQuery);
		List<ReviewDto> reviewDtoList = new ArrayList<ReviewDto>();
		for(Review review:reviewIterable){
			reviewDtoList.add(ConvertUtil.convertSearchedReviewToDto(review,100));
		}
		return reviewDtoList;
	}
	
	public List<ReviewDto> getCurrentUserReviewList(String currentUserEmail){
		List<Review> reviewIterable = reviewRepository.searchReviewByUserName(currentUserEmail);
		List<ReviewDto> reviewDtoList = new ArrayList<ReviewDto>();
		for(Review review:reviewIterable){
			reviewDtoList.add(ConvertUtil.convertSearchedReviewToDto(review,100));
		}
		return reviewDtoList;
	}
	
	public List<ReviewDto> getLatestReviewList(){
		List<Review> reviewIterable = reviewRepository.getLatestReviewList();
		List<ReviewDto> reviewDtoList = new ArrayList<ReviewDto>();
		for(Review review:reviewIterable){
			reviewDtoList.add(ConvertUtil.convertSearchedReviewToDto(review,100));
		}
		return reviewDtoList;
	}
	
	


}
