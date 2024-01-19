package com.spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.blog.domain.Post;
import com.spring.blog.domain.User;
import com.spring.blog.dto.ResponseDTO;
import com.spring.blog.service.PostService;

import jakarta.servlet.http.HttpSession;


@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping({"", "/"})
	public String getPostList(Model model) {
		model.addAttribute("postList", postService.getPostList());
		return "index";
	}
	
	@GetMapping("/post/write")
	public String write() {
		return "post/write";
	}
	
	@PostMapping("/post/write")
	public @ResponseBody ResponseDTO<?> write(HttpSession session, @RequestBody Post post) {
		post.setUser((User)session.getAttribute("user"));
		
		if (post.getUser() != null) {
			postService.write(post);
			return new ResponseDTO<>(HttpStatus.OK.value(), "글 작성 성공하였습니다.");
		}
		
		return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "글 작성 실패하였습니다.");
	}
}
