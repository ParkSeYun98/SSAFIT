package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.SearchCondition;

public interface ReviewService {
	
	// 전체 리뷰 조회
	public List<Review> getReviewList();
	
	// 리뷰 상세 조회 (리뷰 아이디)
	public Review readReviewById(int id); 
	
	// 리뷰 상세 조회 (영상 아이디)
	public List<Review> readReviewListByVideoId(String videoId);
	
	// 리뷰 작성
	public int writeReview(Review review);

	// 리뷰 삭제 
	public int removeReview(int id);
	
	// 리뷰 수정
	public int modifyReview(Review review);
	
	// 리뷰 검색
	public List<Review> search(SearchCondition condition);
}
