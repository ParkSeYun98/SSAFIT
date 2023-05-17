package com.ssafy.fit.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.User;
import com.ssafy.fit.model.service.UserService;
import com.ssafy.fit.util.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	// 로그인
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
//		User loginUser = userService.login(user.getId(), user.getPassword());
//		
//		System.out.println(user);
//		
//		if(loginUser == null)
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		
//		session.setAttribute("loginUser", loginUser);
//		return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//	}
	
	//JWT 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		HttpStatus status = null;
		
		// user를 이용해서 service -> dao -> db를 통해 실제 유저인지 확인해야하는데 그거는 직접 하셈
		User loginUser = userService.login(user.getId(), user.getPassword());
		
		if(loginUser == null)
			throw new IllegalArgumentException("로그인 유저 검사햇는데 null로 나옴");
		
		System.out.println(loginUser.getName());
		// 아이디가 널이 아니거나 길이가 있거나
		try {
			if(user.getId() != null || user.getId().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("username", loginUser.getName());
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch(UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.removeAttribute("access-token");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		System.out.println(user);
		
		int result = userService.addUser(user);
		
		if(result != 0)
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	// 회원 정보 수정
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user) {
		try {
			int result = userService.updateUser(user);
			
			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 회원 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			int result = userService.deleteUser(id);
			
			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST); 
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 전체 회원 리스트
	@GetMapping("/list")
	public ResponseEntity<?> selectAll() {
		try {
			List<User> users = userService.selectAllUser();
			
			if(users != null && users.size() > 0)
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 아이디로 회원 정보 얻기
	@GetMapping("/user/{id}")
	public ResponseEntity<?> selectUserById(@PathVariable String id) {
		try {
			User user = userService.readUser(id);
			
			if(user != null)
				return new ResponseEntity<User>(user, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
