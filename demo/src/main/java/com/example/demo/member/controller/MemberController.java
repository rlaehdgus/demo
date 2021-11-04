package com.example.demo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기

        mav.setViewName("thymeleaf/member/login");

        return mav;
    }

    // 로그인 Proc
    @PostMapping(value = "/loginProc")
    public ModelAndView loginProc() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기)

        // if 사용자가 입력한 정보로 DB에 회원 정보가 있는지 체크 (회원 정보가 있을 경우 success, 없을 경우 fail 처리)

        // success
        // 로그인 세션 추가 후 메인으로 리다이렉트

        // fail
        // 메인으로 리다이렉트

        return mav;
    }
}
