package com.ohgiraffers.associationmapping.section01.manyToOne;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {

    private int menuCode;

    private String menuName;

    private int menuPrice;

    private CategoryDTO categoryCode;

    private String ordrableStatus;
}
