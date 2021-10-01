package com.example.demo.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/register")
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        return mav;
    }
}
