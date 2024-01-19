package com.spring.blog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class BlogExceptionHandler {
	@ExceptionHandler(value = Exception.class) // 원하는 예외처리를 value로 설정하고 핸들링하는 어노테이션
	public String globalExceptionHandler(Exception e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
