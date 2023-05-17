package com.ssafy.fit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.service.VideoService;

@RestController
@RequestMapping("/api-video")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VideoController {

	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

	@Autowired
	private VideoService videoService;
	
	@GetMapping("/videoByPart/{part}")
	public ResponseEntity<?> getVideoListByPart(@PathVariable String part) {
		List<Video> list = videoService.readVideoByPart(part);
	
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/video")
	public ResponseEntity<?> getVideoList() {
		List<Video> list = videoService.readVideoList();
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/videoById/{id}")
	public ResponseEntity<?> getVideoById(@PathVariable String id) {
		Video video = videoService.readVideoById(id);
		
		if(video == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
}
