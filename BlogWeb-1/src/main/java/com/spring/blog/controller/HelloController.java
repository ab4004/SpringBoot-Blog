package com.spring.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	@GetMapping("/html")
	public String getHtml() {
		return "redirect:hello.html";
	}
	
	@GetMapping("/jsp")
	public String getMethodName(Model model) {
		model.addAttribute("username", "Lee-jaewook");
		
		return "hello"; 
	}
	
}
