package com.ganesh.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @created: 29/09/2021 - 11:58 AM
 * @author: Ganesh
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message){
        super(message);
    }
}
