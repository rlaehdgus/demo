package com.example.demo.member.controller;

import com.example.demo.domain.Member;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.MemberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {

    private MemberServiceImpl memberServiceImpl;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기

        mav.setViewName("thymeleaf/member/login");

        return mav;
    }

    // 로그인 Proc
    @PostMapping(value = "/loginProc")
    public ModelAndView loginProc(Member member
        , @RequestParam("id") String userId) {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기)

        // if 사용자가 입력한 정보로 DB에 회원 정보가 있는지 체크 (회원 정보가 있을 경우 success, 없을 경우 fail 처리)

        // success
        // 로그인 세션 추가 후 메인으로 리다이렉트
        System.out.println("member: "+member);
        System.out.println("member id: "+userId);
        UserDetails userDetails = memberServiceImpl.loadUserByUsername(userId);
        System.out.println("userDetails: "+userDetails);
        mav.setViewName("redirect:/blog/main");

        // fail
        // 메인으로 리다이렉트

        return mav;
    }

    @GetMapping(value = "/join")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기

        mav.setViewName("thymeleaf/member/join");

        return mav;
    }

    // 로그인 Proc
    @PostMapping(value = "/joinProc")
    public ModelAndView joinProc(Member member) {
        ModelAndView mav = new ModelAndView();

        // if 로그인 여부 체크 (로그인이 되어있을 경우 메인화면으로 팅겨내기)

        // if 사용자가 입력한 정보로 DB에 회원 정보가 있는지 체크 (회원 정보가 있을 경우 success, 없을 경우 fail 처리)

        // success
        // if 사용자가 입력한 Password와 RePassword의 값이 같은지 체크 (정보가 같을 경우 success, 다를 경우 fail 처리)

            // success
            // 입력한 정보 insert
            memberServiceImpl.joinUser(member);
            mav.setViewName("redirect:/member/login");

            // fail
            // 비밀번호 다시 입력해달라는 메시지를 띄우고 return false 처리

        // fail
        // 메인으로 리다이렉트

        return mav;
    }
}
