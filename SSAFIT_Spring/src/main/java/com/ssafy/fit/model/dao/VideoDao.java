package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Video;

public interface VideoDao {
	
	// 주어진 부위의 비디오 목록 읽기
	List<Video> selectVideoByPart(String part);
	
	// 비디오 조회 수 증가
	void updateVideoViewCnt(String id);
	
	// 전체 비디오 목록 읽기
	List<Video> selectVideoList();
	
	// 비디오 ID로 특정 비디오 읽기
	Video selectVideoById(String id);
}
