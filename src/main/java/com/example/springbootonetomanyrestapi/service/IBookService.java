package com.example.springbootonetomanyrestapi.service;

import com.example.springbootonetomanyrestapi.jpa.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();
    Optional<Book> findById(Integer id);
    Book save(Book book);
    void remove(Integer id);
}
