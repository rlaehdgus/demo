package com.example.demo.admin.LoginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/blog/admin")
public class AdminLoginController {

    @GetMapping("/login")
    public ModelAndView admLogin() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("thymeleaf/admin/login");

        return mav;
    }

    @PostMapping("/loginProc")
    public ModelAndView admLoginProc() {
        ModelAndView mav = new ModelAndView();

        boolean admInfo;
        // 계정정보 확인 후 true or false 값을 admInfo 변수에 저장

        // if(admInfo == true)
        // 계정 정보 세션에 저장 후 관리자 메인 페이지로 이동

        // else
        // 다시 로그인페이지로 리다이렉트

        mav.setViewName("thymeleaf/admin/login");

        return mav;
    }
}
