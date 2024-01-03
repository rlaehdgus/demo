package com.example.demo.blog.main.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Post;

@Repository(value = "MainRepository")
@Mapper
public interface MainRepository {
	
	// 블로그 게시물 조회
	List<Post> getBlogList(Post post);
}
