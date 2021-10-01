package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<String> resultList = new ArrayList<String>();

        resultList.add("AAA");
        resultList.add("BBB");
        resultList.add("CCC");
        resultList.add("DDD");
        resultList.add("EEE");
        resultList.add("FFF");

        mav.addObject("resultList", resultList);
        mav.setViewName("thymeleaf/board/list");

        return mav;
    }
}
