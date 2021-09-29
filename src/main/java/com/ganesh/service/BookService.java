package com.ganesh.service;


import com.ganesh.dto.BookRequestDto;
import com.ganesh.model.Book;

import java.util.List;

/**
 * @created: 29/09/2021 - 11:39 AM
 * @author: Ganesh
 */


public interface BookService {
   public Long createNewBook(BookRequestDto bookRequestDto);
   public List<Book> getAllBooks();
   public Book getBookById(Long id);
   public Book updateBook(Long id, BookRequestDto bookRequestDto);
   public void deleteBookById(Long id);
}
