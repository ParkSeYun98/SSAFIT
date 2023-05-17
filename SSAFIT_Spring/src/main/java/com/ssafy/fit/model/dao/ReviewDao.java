package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.SearchCondition;

public interface ReviewDao {

	// 전체 리뷰 읽기
	List<Review> selectAllReview();
	
	// 아이디에 해당하는 리뷰 읽기
	Review selectReviewById(int id);
	
	// 비디오 아이디에 해당하는 리뷰 리스트 읽기
	List<Review> selectReviewListByVideoId(String videoId);
	
	// 리뷰 등록
	int insertReview(Review review);
	
	// 리뷰 삭제
	int deleteReview(int id);
	
	// 리뷰 수정
	int updateReview(Review review);
	
	// 리뷰 조회수 증가
	void updateReviewViewCnt(int id);
	
	// 리뷰 검색
	List<Review> search(SearchCondition condition);
}
