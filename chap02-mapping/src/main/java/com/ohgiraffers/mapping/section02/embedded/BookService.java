package com.ohgiraffers.mapping.section02.embedded;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void registBook(BookRegistDTO book) {

        Book book1 = new Book(
                book.getBookTitle(),
                book.getAuthor(),
                book.getPulisher(),
                book.getCreatedDate(),
                new Price(
                book.getRegularPrice(),
                book.getDiscountRate()
                )
        );

        bookRepository.save(book1);

    }
}
