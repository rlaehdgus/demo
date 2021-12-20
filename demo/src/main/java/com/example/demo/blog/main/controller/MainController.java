package com.example.demo.blog.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class MainController {

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("thymeleaf/index");

        return mav;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (미로그인 시 return false 처리)

        // 메인 이미지 데이터 조회

        // 공지 게시글 조회

        // 블로그 게시글 리스트로 조회

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
