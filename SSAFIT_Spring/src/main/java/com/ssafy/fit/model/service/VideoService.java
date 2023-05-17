package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Video;

public interface VideoService {
	
	public List<Video> readVideoByPart(String part);
	
	public List<Video> readVideoList();
	
	public Video readVideoById(String id);
}
