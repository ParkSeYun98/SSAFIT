package com.ssafy.fit.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fit.model.dao.UserDao;
import com.ssafy.fit.model.dto.User;

//빈으로 등록될 수 있도록 @Service 선언
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ResourceLoader resLoader;
	
	private UserDao userDao;
	
	// 생성자 주입
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User readUser(String id) {
		return userDao.selectUser(id);
	}

	@Override
	@Transactional
	public int addUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectUser(id);

		if(tmp != null && tmp.getPassword().equals(password))
			return tmp;
		
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(String id) {
		return userDao.deleteUser(id);
	}
}
