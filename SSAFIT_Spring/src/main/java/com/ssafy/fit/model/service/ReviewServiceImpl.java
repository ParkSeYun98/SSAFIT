package com.ssafy.fit.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fit.model.dao.ReviewDao;
import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.SearchCondition;

//빈으로 등록될 수 있도록 @Service 선언
@Service
public class ReviewServiceImpl implements ReviewService {

	private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	private ResourceLoader resLoader;
	
	private ReviewDao reviewDao;
	
	// 생성자 주입
	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<Review> getReviewList() {
		return reviewDao.selectAllReview();
	}

	@Override
	public Review readReviewById(int id) {
		reviewDao.updateReviewViewCnt(id);
		return reviewDao.selectReviewById(id);
	}
	
	@Override
	public List<Review> readReviewListByVideoId(String videoId) {
		return reviewDao.selectReviewListByVideoId(videoId);
	}

	@Override
	@Transactional
	public int writeReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	@Transactional
	public int removeReview(int id) {
		return reviewDao.deleteReview(id);
	}

	@Override
	@Transactional
	public int modifyReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public List<Review> search(SearchCondition condition) {
		return reviewDao.search(condition);
	}
}
