package com.ssafy.fit.model.dto;

public class SearchCondition {
	
	private String key = "none";
	private String word;
	private String orderBy = "none";
	private String orderByDir = "asc";
	
	public SearchCondition() { //기본생성자는 습관처럼 만들자.
	
	}
	
	public SearchCondition(String key, String word, String orderBy, String orderByDir) {
		this.key = key;
		this.word = word;
		this.orderBy = orderBy;
		this.orderByDir = orderByDir;
	}

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getOrderByDir() {
		return orderByDir;
	}
	
	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	}

	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", word=" + word + ", orderBy=" + orderBy + ", orderByDir=" + orderByDir
				+ "]";
	}
}
