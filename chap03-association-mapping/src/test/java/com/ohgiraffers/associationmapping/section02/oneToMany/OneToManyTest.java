package com.ohgiraffers.associationmapping.section02.oneToMany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private OneToManyService oneToManyService;

    @DisplayName("1:N 연관관계 객체 그래프 탐색 조회")
    @Test
    void oneToManyFind(){

        int categoryCode = 10;

        Category category = oneToManyService.findCategory(categoryCode);

        System.out.println("확인용 = " + category.getMenuList());

        Assertions.assertNotNull(category);
    }
}

