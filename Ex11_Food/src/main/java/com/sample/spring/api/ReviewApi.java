package com.sample.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.api.request.CreateReviewRequest;
import com.sample.spring.repository.ReviewRepository;
import com.sample.spring.sevice.ReviewService;

@RestController
public class ReviewApi {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/review")
	public ResponseEntity<String> createReview(
			@RequestBody CreateReviewRequest request
			) {
		reviewService.createReview(
				request.getFoodId(), 
				request.getContent(),
				request.getScore());
		
		return ResponseEntity.status(HttpStatus.CREATED).body("success");
	}
	
	@DeleteMapping("/review/{reviewId}")
	public void deleteReview(
			@PathVariable("reviewId") Long reviewId
			) {
		reviewService.deleteReview(reviewId);
		
	}

}
