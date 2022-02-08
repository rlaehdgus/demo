package com.example.demo.blog.mypage.controller;

import com.example.demo.blog.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/mypage")
public class MypageController {

    private UserService userService;

    @GetMapping(value = "/info")
    public ModelAndView info(Principal principal) {
        ModelAndView mav = new ModelAndView();

//        memberServiceImpl

//        UserDetails userDetails = memberServiceImpl.loadUserByUsername(principal.getName());
//        System.out.println("userDetails: "+ userDetails);

//        mav.addObject("user", userDetails);
        mav.setViewName("thymeleaf/mypage/mypage");

        return mav;
    }

}
