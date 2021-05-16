package com.example.springbootonetomanyrestapi.repository;

import com.example.springbootonetomanyrestapi.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
