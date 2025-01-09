package com.ohgiraffers.mapping.section03.compositekey.idclass;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartCompositeKey implements Serializable {

    private int carOwner; // 카트 주인
    private int addedBook; // 추가 된 책

}
