package com.ohgiraffers.springdatajpa.Menu.model.service;

import com.ohgiraffers.springdatajpa.Menu.entity.Category;
import com.ohgiraffers.springdatajpa.Menu.entity.Menu;
import com.ohgiraffers.springdatajpa.Menu.model.dao.CategoryRepository;
import com.ohgiraffers.springdatajpa.Menu.model.dao.MenuRepository;
import com.ohgiraffers.springdatajpa.Menu.model.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.Menu.model.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;
    // Bean 으로 등록한 modelMapper 의존성 주입
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* text 1. 메뉴 코드로 특정 메뉴 조회하기 */
    public MenuDTO findMenuByMenuCode(int menuCode) {

        Menu menu = repository.findById(menuCode).
                               orElseThrow(IllegalArgumentException::new); // 잘못 된 파라미터가 넘겨왔을 때 예외처리 필수

        // entity 를 dto 로 변환
        // map(변환 entity, 변활할 dto)
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* text. 페이징 처리하지 않은 메뉴 리스트 조회하기 */
    public List<MenuDTO> findAllMenu() {

        // List<Menu> menuList = repository.findAll(); 정렬 없는 findAll
        List<Menu> menu = repository.findAll(Sort.by("menuPrice").descending());

        System.out.println("서비스 메뉴 = " + menu);
        // stream : 컬렉션 등등 데이털르 처리하기 위해 나열
        // map : 스트림화 된 데이터를 꺼내 매핑 및 변환
        return menu.stream().map(menulist -> modelMapper.map(menulist, MenuDTO.class)).collect(Collectors.toList());
    }

    /* text. 페이징 처리를 한 메뉴 전체 조회 */
    public Page<MenuDTO> findAllMenuByPaging(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );
        // 위에 설정한 정보를 같이 레파지토리에 넘겨준다.
        Page<Menu> menu = repository.findAll(pageable);

        return menu.map(menulist -> modelMapper.map(menulist, MenuDTO.class));
    }

    public List<MenuDTO> findByMenuPrice(int menuPrice) {

        List<Menu> menu = repository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);

        return menu.stream()
                .map(menulist -> modelMapper.map(menulist, MenuDTO.class))
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categorylist = categoryRepository.findAllCategory();

        return categorylist.stream().map(category -> modelMapper
                                    .map(category, CategoryDTO.class))
                                    .collect(Collectors.toList());
    }

    @Transactional
    public void registMenu(MenuDTO menuDTO) {

        // 지금까지는 Entity 를 DTO 로 변환했다면
        // DML 구문에서는 DTO 타입을 Entity 로 변환을 해야
        // Persistence Context == JPA 가 관리를 해준다.
        repository.save(modelMapper.map(menuDTO, Menu.class));
    }

    @Transactional
    public void deleteMenu(int menuCode) {

        modelMapper.map(menuCode, Menu.class);

        repository.deleteById(menuCode);
    }

    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {
        /* comment. update 는 엔티티를 특정해서 필드 값을 변경해주면 된다.
         *   JPA 는 변경 감지 기능이 있어서 하나의 엔티티를 특정하여
         *   필드 값을 변경하면 변경 된 값으로 flush(반영) 해준다. */

        // 특정 엔티티 찾기
        Menu foundMenu = repository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        System.out.println("찾은 Entity 값 = " + foundMenu);

        /* comment. 값을 수정하는 방식1 - setter 를 통해 update 가능 (지양하는 방법) */
//        foundMenu.setMenuName(modifyMenu.getMenuName());
//        System.out.println("setter 사용 후 foundMenu = " + foundMenu);

        /* comment. 값을 수정하는 방식2 - 엔티티에 @Builder 어노테이션을 통해 update 기능 */
        foundMenu = foundMenu.toBuilder()
                             .menuName(modifyMenu.getMenuName())
                             .build();
//
//        // build 를 통해서 foundMenu 를 새롭게 탄생시킨 후 save 메소드를 통해 JPA 에게 전달
//        repository.save(foundMenu);

        /* comment. 값을 수정하는 방식3 - Entity 내부에 builder 패턴을 구현 */
//        foundMenu = foundMenu.menuName(modifyMenu.getMenuName()).builder();
//
//        repository.save(foundMenu);
    }

}
