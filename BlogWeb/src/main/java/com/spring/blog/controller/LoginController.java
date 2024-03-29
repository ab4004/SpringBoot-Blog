package com.spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.blog.dto.ResponseDTO;
import com.spring.blog.service.UserService;
import com.spring.blog.user.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
	@PostMapping("/auth/login")
	public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUsername());
		
		if (findUser.getUsername() != null) {
			if (findUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "님 로그인에 성공하였습니다.");
			}
		}
		
		return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "로그인에 실패하였습니다.");
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
