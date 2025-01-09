package com.ohgiraffers.associationmapping.section01.manyToOne;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManyToOneService {

    @Autowired
    private ManyToOneRepository repository;

    @Transactional
    public void registMenu(MenuDTO menu) {

        Menu menu1 = new Menu(
                menu.getMenuCode(),
                menu.getMenuName(),
                menu.getMenuPrice(),
                new Category(
                        menu.getCategoryCode().getCategoryCode(),
                        menu.getCategoryCode().getCategoryName(),
                        menu.getCategoryCode().getRefCategoryCode()
                        ),
                menu.getOrdrableStatus()
        );

        repository.registMenu(menu1);

    }

    public Menu find(int menuCode) {

        return repository.find(menuCode);
    }

    public String findCategoryName(int menuCode) {

        return repository.findCategoryName(menuCode);
    }
}
