package com.spring.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.domain.RoleType;
import com.spring.blog.domain.User;
import com.spring.blog.exception.UserException;
import com.spring.blog.persistence.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		
		return user.getUsername() + "님 환영합니다. 회원가입이 완료되었습니다.";
	}
	
	@GetMapping("/user/get/{id}")
	public User getUser(@PathVariable int id) {
		User findUser = userRepository.findById(id).orElseThrow(() -> {
			return new UserException(id + "번 아이디를 찾을 수 없습니다.");
		});

		return findUser;
	}

	
	@PutMapping("/user")
	public String updateUser(@RequestBody User user) {
		User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new UserException(user.getId() + "번 아이디를 찾을 수 없습니다.");
		});
		
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());

		userRepository.save(findUser);
		
		return findUser.getUsername() + "님의 정보가 수정되었습니다.";
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
		return id + "번 회원님의 정보가 삭제되었습니다.";
	}
	
	@GetMapping("/user/list")
	public List<User> getUserList() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/page/{page}")
	public Page<User> getUserListPaging(@PathVariable int page) {
		Pageable pageable = PageRequest.of(page, 2, Direction.DESC, "id", "username");
		return userRepository.findAll(pageable);
	}
	
	@GetMapping("/auth/insertUser")
	public ModelAndView insertUser(ModelAndView mav) {
		mav = new ModelAndView("user/insertUser");
		return mav;
	}
	
}
