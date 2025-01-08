package com.ohgiraffers.mapping.section03.compositekey.embeddedid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LikedBookNo {

    @Column(name = "likded_book_no")
    private int likedBookNo;

    public LikedBookNo() {}

    public LikedBookNo(int likedBookNo) {
        this.likedBookNo = likedBookNo;
    }
}
