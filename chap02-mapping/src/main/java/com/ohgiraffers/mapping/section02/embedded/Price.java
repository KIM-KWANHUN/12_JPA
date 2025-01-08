package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

// @Embeddable 란?
// 다른곳에서 가능하게 설정
@Embeddable
public class Price {

    // 출판 가격(10000), 할인율(10%), 판매 가격(9000) 이런느낌으로 관리
    @Column(name = "regular_price")
    private int regularPrice; // 출판 가격

    @Column(name = "discount_rate")
    private double discountRate; // 할인율

    @Column(name = "sell_price")
    private int sellPrice; // 할인율이 적용된 실제 판매 가격

    public Price() {}

    public Price(int regularPrice, double discountRate) {
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
    }
}
