package com.ohgiraffers.associationmapping.section02.oneToMany;

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

    private int categoryCode;

    private String ordrableStatus;
}
