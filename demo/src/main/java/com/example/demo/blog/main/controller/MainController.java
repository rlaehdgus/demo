package com.example.demo.blog.main.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.blog.main.service.MainService;
import com.example.demo.domain.Post;
import com.example.demo.security.BlogUser;
import com.example.demo.security.BlogUserDetailsService;

@Controller
@RequestMapping("/blog")
public class MainController {
	
	private MainService mainService;
	private BlogUserDetailsService blogUserDetailsService;

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("thymeleaf/index");

        return mav;
    }

    @GetMapping("/list")
    public ModelAndView list(Post post) {
        ModelAndView mav = new ModelAndView();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userName);
        BlogUser user = blogUserDetailsService.loadUserByUsername(userName);

        // if 로그인 여부 체크 (미로그인 시 return false 처리)

        // 메인 이미지 데이터 조회

        // 공지 게시글 조회

        // 블로그 게시글 리스트로 조회
        System.out.println(user.getUserNo());
        post.setRegUserNo(user.getUserNo());
        //System.out.println(post);
        mainService.getBlogList(post);

        mav.setViewName("thymeleaf/blog/main");

        return mav;
    }

    @GetMapping("/view")
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (미로그인 시 return false 처리)

        // 블로그 게시물 내용 조회

        // 블로그 게시물에 해당하는 댓글 조회

        mav.setViewName("thymeleaf/blog/view");

        return mav;
    }
}
