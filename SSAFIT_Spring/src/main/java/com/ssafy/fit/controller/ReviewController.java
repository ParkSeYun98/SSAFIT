package com.ssafy.fit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.SearchCondition;
import com.ssafy.fit.model.service.ReviewService;

@RestController
@RequestMapping("/api-review")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/reviewById/{id}")
	public ResponseEntity<?> selectReviewById(@PathVariable int id) {
		try {
			Review review = reviewService.readReviewById(id);
			
			if(review != null)
				return new ResponseEntity<Review>(review, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/review/search")
	public ResponseEntity<?> searchReview(@ModelAttribute SearchCondition condition) {
		try {
			List<Review> reviews = reviewService.search(condition);
			
			if(reviews != null)
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/review/{videoId}")
	public ResponseEntity<?> selectReviewList(@PathVariable String videoId) {
		try {
			List<Review> reviews = reviewService.readReviewListByVideoId(videoId);
			
			if(reviews != null)
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@PostMapping("/review")
	public ResponseEntity<?> insertReview(@RequestBody Review review) {
		try {
			int result = reviewService.writeReview(review);
			
			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/review")
	public ResponseEntity<?> updateReview(@RequestBody Review review) {
		try {
			int result = reviewService.modifyReview(review);
			
			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable int id) {
		try {
			int result = reviewService.removeReview(id);
			
			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
