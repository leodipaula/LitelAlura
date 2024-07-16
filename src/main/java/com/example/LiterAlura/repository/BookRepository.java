package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.Author;
import com.example.LiterAlura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleContainingIgnoreCase(String titleBook);
}
