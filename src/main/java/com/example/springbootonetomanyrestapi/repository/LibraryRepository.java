package com.example.springbootonetomanyrestapi.repository;

import com.example.springbootonetomanyrestapi.jpa.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
