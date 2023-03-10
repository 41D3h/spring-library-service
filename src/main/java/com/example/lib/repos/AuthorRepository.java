package com.example.lib.repos;

import com.example.lib.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Iterable<Author> findAllByOrderBySurname();

    Iterable<Author> findAllByNameOrSurnameOrPatronymicOrderBySurname(String name, String surname, String patronymic);
}
