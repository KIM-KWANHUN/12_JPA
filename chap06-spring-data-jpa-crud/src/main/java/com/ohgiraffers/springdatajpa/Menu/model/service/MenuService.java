package com.ohgiraffers.springdatajpa.Menu.model.service;

import com.ohgiraffers.springdatajpa.Menu.model.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;

    /* text 1. 메뉴 코드로 특정 메뉴 조회하기 */
    public MenuDTO findMenuByMenuCode(int menuCode) {

        repository.

        return modelmapper.
    }
}
