package com.ohgiraffers.springdatajpa.Menu.controller;

import com.ohgiraffers.springdatajpa.Menu.model.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.Menu.model.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor        // 필드에 final 키워드가 붙은 객체들을 자동으로 생성자 주입을 해준다.
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public String findMenuByPathVariable(@PathVariable int menuCode, Model model) {

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }
}
