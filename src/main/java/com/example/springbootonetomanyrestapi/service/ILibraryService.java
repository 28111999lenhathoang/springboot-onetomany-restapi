package com.example.springbootonetomanyrestapi.service;

import com.example.springbootonetomanyrestapi.jpa.Library;

import java.util.List;
import java.util.Optional;

public interface ILibraryService {
    List<Library> findAll();
    Optional<Library> findById(Integer id);
    Library save(Library library);
    void remove(Integer id);
}
