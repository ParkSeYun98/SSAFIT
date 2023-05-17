package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.User;

public interface UserDao {
	
	// 해당 id에 맞는 유저 읽기
	User selectUser(String id);
	
	// 회원가입
	int insertUser(User user); 
	
	// 회원 정보 수정
	int updateUser(User user);
	
	// 회원 탈퇴
	int deleteUser(String id);
	
	// 전체 회원 목록 읽기
	List<User> selectAllUser();
}
