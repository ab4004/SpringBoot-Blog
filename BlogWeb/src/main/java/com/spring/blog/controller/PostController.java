package com.spring.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
}
