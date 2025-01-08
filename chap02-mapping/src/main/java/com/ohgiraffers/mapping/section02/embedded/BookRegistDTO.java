package com.ohgiraffers.mapping.section02.embedded;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookRegistDTO {

    private String bookTitle;
    private String author;
    private String pulisher;
    private LocalDateTime createdDate;
    private int regularPrice;
    private double discountRate;
}
