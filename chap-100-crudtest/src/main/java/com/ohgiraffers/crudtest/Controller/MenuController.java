package com.ohgiraffers.crudtest.Controller;

import com.ohgiraffers.crudtest.Model.DTO.Menu;
import com.ohgiraffers.crudtest.Model.DTO.MenuDTO;
import com.ohgiraffers.crudtest.Model.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping
    public String findMenuAll(Model model) {

        List<MenuDTO> menulist = menuService.findMenuAll();

        System.out.println("컨트롤러 테스트 = " + menulist);

        model.addAttribute("menulist", menulist);

        return "/menu";

    }

    @GetMapping("/menu/{menuCode}")
    public String findMenuByCode(Model model, @PathVariable int menuCode){

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        System.out.println("메뉴 상세조회 컨트롤러 테스트 = " + menu);

        model.addAttribute("menu", menu);

        return "/detail";
    }

    @GetMapping("/menu/detail/update/{menuCode}")
    public void update(){}

    @PostMapping("/menu/detail/update/{menuCode}")
    public String findMenuModify(@PathVariable int menuCode, Model model) {
        MenuDTO menu = menuSer vice.findMenuModify(menuCode);

        model.addAttribute("menu", menu);

        return "redirect: /menu";
    }
}
