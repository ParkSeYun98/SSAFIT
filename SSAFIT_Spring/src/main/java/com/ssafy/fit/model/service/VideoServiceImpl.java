package com.ssafy.fit.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dto.Video;

// 빈으로 등록될 수 있도록 @Service 선언
@Service
public class VideoServiceImpl implements VideoService {
	
	private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

	@Autowired
	private ResourceLoader resLoader;
	
	private VideoDao videoDao;
	
	// 생성자 주입
	@Autowired
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Override
	public List<Video> readVideoByPart(String part) {
		return videoDao.selectVideoByPart(part);
	}

	@Override
	public List<Video> readVideoList() {
		return videoDao.selectVideoList();
	}

	@Override
	public Video readVideoById(String id) {
		return videoDao.selectVideoById(id);
	}

}
