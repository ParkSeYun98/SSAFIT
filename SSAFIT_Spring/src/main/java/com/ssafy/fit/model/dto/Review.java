package com.ssafy.fit.model.dto;

public class Review {
	
	private String videoId;
	private int id;
	private String title;
	private String writer;
	private int viewCnt;
	private String regDate;
	private String description;
	
	public Review() {
		
	}

	public Review(String videoId, int id, String title, String writer, int viewCnt, String regDate,
			String description) {
		this.videoId = videoId;
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		this.description = description;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [videoId=" + videoId + ", id=" + id + ", title=" + title + ", writer=" + writer + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + ", description=" + description + "]";
	}
}
