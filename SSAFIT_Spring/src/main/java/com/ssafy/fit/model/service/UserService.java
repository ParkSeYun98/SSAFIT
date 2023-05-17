package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.User;

public interface UserService {
	
	// 해당 id에 해당하는 유저 읽기
	public User readUser(String id);
	
	// 전체 회원 읽기
	public List<User> selectAllUser();
	
	// 회원가입
	public int addUser(User user);
	
	// 로그인
	public User login(String id, String password);
	
	// 회원 정보 수정
	int updateUser(User user);
	
	// 회원 삭제
	int deleteUser(String id);
}
