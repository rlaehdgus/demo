package com.example.demo.blog.main.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.blog.main.service.MainService;
import com.example.demo.blog.user.service.impl.UserRepository;
import com.example.demo.domain.Post;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService {
	
	private MainRepository mainRepository;
	
	@Override
	public List<Post> getBlogList(Post post) {
		return mainRepository.getBlogList(post);
	}
}
