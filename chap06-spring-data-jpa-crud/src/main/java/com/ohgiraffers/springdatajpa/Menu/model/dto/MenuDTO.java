package com.ohgiraffers.springdatajpa.Menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {

    /* text.
    *   DTO 는 VIEW 에서 넘어오는 혹은 넘겨줄 값으로 필드를 구성하는 데이터를 전송하기 위한 객체이다. */

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
