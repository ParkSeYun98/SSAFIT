package com.ssafy.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 전역 레벨에서 서버 오류를 처리하기 위해 @ControllerAdvice를 사용
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		
		logger.error("예외 처리", e.getCause());
		e.printStackTrace();
		
		ModelAndView mnv = new ModelAndView();
		
		// 해커 공격의 빌미를 제공할 수 있음으로 서버에서 발생한 구체적인 오류를 표시하지는 않는다.
		if (e instanceof BindException) 
			mnv.addObject("errmsg", "파라미터가 잘 전달되었는지 확인하세요.");
		
		// 키 중복에 대한 오류가 발생하면 아래 메시지를 적용한다.
		else if (e instanceof DuplicateKeyException) {
			logger.debug("duplicate key exception");
			mnv.addObject("errmsg", "동일한 키가 이미 사용중입니다.");
		}
		
		// 예외가 발생되면 /error/err을 호출한다.
		mnv.setViewName("/error/errPage");
		return mnv;
	}
}
