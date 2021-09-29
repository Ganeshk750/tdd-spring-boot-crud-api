package com.ganesh.service.impl;


import com.ganesh.dto.BookRequestDto;
import com.ganesh.exception.BookNotFoundException;
import com.ganesh.model.Book;
import com.ganesh.repository.BookRepository;
import com.ganesh.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @created: 29/09/2021 - 11:43 AM
 * @author: Ganesh
 */


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public Long createNewBook(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setIsbn(bookRequestDto.getIsbn());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setTitle(bookRequestDto.getTitle());
        book = bookRepository.save(book);
        return  book.getId();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book getBookById(Long id) {
        Optional<Book> requestedBook = bookRepository.findById(id);
         if(requestedBook.isEmpty()){
             throw new BookNotFoundException(String.format("Book with id: '%s' not found", id));
         }
         return requestedBook.get();
    }

    @Transactional
    @Override
    public Book updateBook(Long id, BookRequestDto bookRequestDto) {

        Optional<Book> bookFormDatabase = bookRepository.findById(id);
        if(bookFormDatabase.isEmpty()){
            throw new BookNotFoundException(String.format("Book with id: '%s' not found", id));
        }
        Book bookToUpdate = bookFormDatabase.get();
        bookToUpdate.setAuthor(bookToUpdate.getAuthor());
        bookToUpdate.setIsbn(bookToUpdate.getIsbn());
        bookToUpdate.setTitle(bookToUpdate.getTitle());
        return bookToUpdate;
    }

    @Override
    public void deleteBookById(Long id) {
       bookRepository.deleteById(id);
    }
}
