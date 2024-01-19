package com.spring.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.user.User;

@RestController
public class RESTController {
	
	@GetMapping("/blog")
	public User httpGet() {
		User findUser = User.builder().id(1).username("test").password("123").email("test@test.com").build();
		return findUser;
	}
	
	@PostMapping("/blog")
	public String httpPost(@RequestBody User user) {
		return "Post 요청 처리 입력값 : " + user.toString();
	}
	
	@PutMapping("/blog")
	public String httpPut(@RequestBody User user) {
		return "Put 요청 처리 입력값 : " + user.toString();
	}
	
	@DeleteMapping("/blog")
	public String httpDelete(@RequestBody User user) {
		return "Delete 요청 처리 입력값 : " + user.toString();
	}
}
