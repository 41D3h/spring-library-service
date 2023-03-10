package com.example.lib.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Поле имя не может быть пустым")
    private String name;

    @NotBlank(message = "Поле фамилия не может быть пустым")
    private String surname;

    private String patronymic;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {}

    public Author(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.getAuthors().add(this);
    }
}
