package com.ohgiraffers.springdatajpa.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // 메인화면
    @GetMapping("/")
    public String indexPage(){

        return "main/main";
    }
}
