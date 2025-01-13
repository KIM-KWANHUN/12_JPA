package com.ohgiraffers.crudtest.Model.Service;
import com.ohgiraffers.crudtest.Model.DAO.MenuRepository;
import com.ohgiraffers.crudtest.Model.DTO.Menu;
import com.ohgiraffers.crudtest.Model.DTO.MenuDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository repository;
    private final ModelMapper modelMapper;
    private final MenuDTO menuDTO;

    public MenuService(ModelMapper modelMapper, MenuRepository repository, MenuDTO menuDTO) {

        this.repository = repository;
        this.modelMapper = modelMapper;
        this.menuDTO = menuDTO;
    }

    public List<MenuDTO> findMenuAll() {

        List<Menu> menuList = repository.findAll();

        System.out.println("서비스쪽 전체 = " + menuList);

        return menuList.stream().map(
                // 엔티티를 DTO 로 변환
                menu -> modelMapper.map(menu, MenuDTO.class)
        ).collect(Collectors.toList());
    }

    public MenuDTO findMenuByCode(int menuCode) {

        Menu menu = repository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        System.out.println("메뉴 상세조회 서비스 텧스트 = " + menu);

        return modelMapper.map(menu, MenuDTO.class);
    }
    @Transactional
    public MenuDTO findMenuModify(int menuCode) {

        Menu menu = repository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        menu.Name(menu.getMenuName());

        return modelMapper.map(menu, MenuDTO.class);
    }
}
