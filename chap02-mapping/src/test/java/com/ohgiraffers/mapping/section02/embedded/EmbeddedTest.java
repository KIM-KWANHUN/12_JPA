package com.ohgiraffers.mapping.section02.embedded;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class EmbeddedTest {

    @Autowired
    private BookService bookService;

    private static Stream<Arguments> getBook() {
        return Stream.of(
                Arguments.of(
                        "JPA의 정석",
                        "너구리",
                        "하이미디어 출판",
                        LocalDateTime.now(),
                        35000,
                        0.1
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Embedded 테스트")
    @MethodSource("getBook")
    void testEmbedded(String bookTitle, String author, String pulisher,
                      LocalDateTime createdDate, int regularPrice, double discountRate) {

        BookRegistDTO book = new BookRegistDTO(
                bookTitle, author, pulisher, createdDate, regularPrice, discountRate);

        Assertions.assertDoesNotThrow(
                () -> bookService.registBook(book)
        );
    } // DTO 에 값 담기

}
