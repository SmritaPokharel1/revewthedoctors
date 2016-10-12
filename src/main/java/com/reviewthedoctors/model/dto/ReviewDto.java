package com.reviewthedoctors.model.dto;

public class ReviewDto{
	
	private long reviewId;
	private double rating;
	private DoctorDto doctor;
	private UserDto user;
	private String review;
	
	private long doctorId;
	private long userId;
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public DoctorDto getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
