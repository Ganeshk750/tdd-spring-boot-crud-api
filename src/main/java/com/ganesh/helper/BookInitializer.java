package com.ganesh.helper;


import com.ganesh.model.Book;
import com.ganesh.repository.BookRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @created: 29/09/2021 - 11:28 AM
 * @author: Ganesh
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class BookInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();
        log.info("---Starting Book Initialization---");
        for(int i = 0; i < 10; i++){
            Book book = new Book();
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setIsbn(UUID.randomUUID().toString());
            bookRepository.save(book);
        }
        log.info("--- Finished Book Initialization ---");
    }
}
