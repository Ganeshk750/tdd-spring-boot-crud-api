package com.ganesh.controller;


import com.ganesh.dto.BookRequestDto;
import com.ganesh.model.Book;
import com.ganesh.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * @created: 29/09/2021 - 12:02 PM
 * @author: Ganesh
 */

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createNewBook(@Valid @RequestBody BookRequestDto bookRequestDto, UriComponentsBuilder uriComponentsBuilder){
        long primaryKey = bookService.createNewBook(bookRequestDto);

        UriComponents uriComponents = uriComponentsBuilder.path("/api/books/{id}").buildAndExpand(primaryKey);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.updateBook(id, bookRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

}
