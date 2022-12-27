package com.manningbooks.catalogservice.domain;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(String isbn) {
        super("A book with ISBN " + isbn + " already exist.");
    }
}
