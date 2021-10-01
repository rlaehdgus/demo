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

        mav.setViewName("thymeleaf/blog/main");

        return mav;
    }

    @GetMapping("/view")
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("thymeleaf/blog/view");

        return mav;
    }
}
