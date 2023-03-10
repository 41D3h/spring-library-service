package com.example.lib.repos;

import com.example.lib.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Iterable<Book> findAllByOrderByName();

    Iterable<Book> findFirst10ByOrderByIdDesc();

    Iterable<Book> findAllByNameOrderByName(String name);
}
