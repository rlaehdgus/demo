package com.example.demo.blog.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;

public interface MainService {

	List<Post> getBlogList(Post post);

}
