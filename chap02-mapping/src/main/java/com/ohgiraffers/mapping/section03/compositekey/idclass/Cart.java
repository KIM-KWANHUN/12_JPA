package com.ohgiraffers.mapping.section03.compositekey.idclass;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
@IdClass(CartCompositeKey.class) // 복합키로 설정할 클래스 명시
public class Cart {

    @Id
    @Column(name = "cart_owner")
    private int carOwner;
    // CartCompositeKey 여기서 썻던 변수에 무조건 동일해야한다.

    @Id
    @Column(name = "added_book")
    private int addedBook;
    // 이것도 마찬가지로 동일 해야함

    @Column(name = "quantity")
    private int quantity; // 수량

    public Cart() {}

    public Cart(int carOwner, int addedBook, int quantity) {
        this.carOwner = carOwner;
        this.addedBook = addedBook;
        this.quantity = quantity;
    }
}
