package com.spring.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.blog.domain.Post;
import com.spring.blog.persistence.PostRepository;


@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void write(Post post) {
		postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	public List<Post> getPostList() {
		return postRepository.findAll();
	}
}
