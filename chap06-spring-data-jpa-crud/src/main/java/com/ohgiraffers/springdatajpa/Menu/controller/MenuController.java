package com.ohgiraffers.springdatajpa.Menu.controller;
import com.ohgiraffers.springdatajpa.Menu.entity.Menu;
import com.ohgiraffers.springdatajpa.Menu.model.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.Menu.model.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.Menu.model.service.MenuService;
import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor        // 필드에 final 키워드가 붙은 객체들을 자동으로 생성자 주입을 해준다.
@Slf4j  // Lombok 라이브러리에서 제공하는 로깅 관련 어노테이션
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public String findMenuByPathVariable(@PathVariable int menuCode, Model model) {

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);
        // 변환된 menu 값이 모델에 담김
        model.addAttribute("menu", menu);

        System.out.println("menu = " + menu);

        return "menu/detail";
    }

    @GetMapping("/list")
    public String findAllMenu(Model model, @PageableDefault Pageable pageable) {

        /* comment. 페이징 처리 하지 않은 findAll() */
//        List<MenuDTO> menuList = menuService.findMenuList();
//
//        model.addAttribute("menus", menuList);

        // @Slf4j 을 클래스위에 명시해주면 로그를 확인 할 수 있다.
        log.info("pageable : {}" , pageable);

        Page<MenuDTO> menuList = menuService.findAllMenuByPaging(pageable);

        log.info("조회할 내용 목록 : {}" , menuList.getContent());
        log.info("총페이지 수 : {}" , menuList.getTotalPages());
        log.info("총메뉴의 수 : {}" , menuList.getTotalElements());
        log.info("해당 페이지에 표현 될 요소의 수 : {}" , menuList.getSize());
        log.info("첫 페이지 여부 : {}", menuList.isFirst());
        log.info("마지막 페이지 여부 : {}", menuList.isLast());
        log.info("정렬방식 : {}", menuList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}", menuList.getNumber());

        PagingButton pagingButton = Pagenation.getPagingInfo(menuList);
        model.addAttribute("menus", menuList);
        model.addAttribute("paging", pagingButton);

        return "menu/list";
    }

    // void 로 요청을 하면 해당하는 뷰페이지가 된다.
    @GetMapping("/querymethod")
    public void queryMethodPage(){}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam int menuPrice, Model model){

        List<MenuDTO> menu = menuService.findByMenuPrice(menuPrice);

        model.addAttribute("menuResult", menu);
        System.out.println("메뉴 컨트롤러 테스트 = " + menu);
        model.addAttribute("price", menuPrice);
        System.out.println("메뉴가격 컨트롤러 테스트 = " + menuPrice);

        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage(){}

    @PostMapping("/regist")
    public String regist(@ModelAttribute MenuDTO menuDTO){

        menuService.registMenu(menuDTO);

        return "redirect:/menu/list";
    }

    @GetMapping(value = "/category", produces = "application/json; chars=UTF-8") // produces = "application/json; chars=UTF-8" 이건 굳이안써도됨
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        // return 구문이 view 지정하는 것이 아닌, Data 를 return 해준다.
        List<CategoryDTO> category = menuService.findAllCategory();

        System.out.println("category = " + category);
        
        return category;
    }

    @GetMapping("/{menuCode}/delete")
    public String deleteMenu(@PathVariable int menuCode){

        menuService.deleteMenu(menuCode);

        System.out.println("삭제할 메뉴 = " + menuCode);

        return "redirect:/menu/list";

    }

    @GetMapping("/modify")
    public void modifyPage(){}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO modifyMenu){

        System.out.println("수정할 정보 객체 확인용 = " + modifyMenu);

        menuService.modifyMenu(modifyMenu);

        return "redirect:/menu/" + modifyMenu.getMenuCode();
    }

}
