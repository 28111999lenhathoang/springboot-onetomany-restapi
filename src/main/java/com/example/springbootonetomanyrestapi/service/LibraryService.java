package com.example.springbootonetomanyrestapi.service;

import com.example.springbootonetomanyrestapi.jpa.Library;
import com.example.springbootonetomanyrestapi.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibraryService implements ILibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(Integer id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Library save(Library library){
        return libraryRepository.save(library);
    }

    @Override
    public void remove(Integer id) {
        libraryRepository.deleteById(id);
    }
}
