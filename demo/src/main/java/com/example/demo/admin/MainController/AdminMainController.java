package com.example.demo.admin.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog/admin")
public class AdminMainController {

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("thymeleaf/admin/main/index");

        return mav;
    }
}
