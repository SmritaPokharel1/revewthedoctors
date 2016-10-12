package com.reviewthedoctors.api;

import java.util.List;

import com.reviewthedoctors.model.dto.ReviewDto;

public interface IReviewApi{

	ReviewDto create(ReviewDto reviewDto);
	ReviewDto update(ReviewDto reviewDto);
	boolean delete(long reviewId);
	ReviewDto getReview(long reviewId);
	List<ReviewDto> getAllReviews();
	List<ReviewDto> searchReview(String searchQuery);
	List<ReviewDto> getCurrentUserReviewList(String currentUserEmail);
	List<ReviewDto> getLatestReviewList();
}
