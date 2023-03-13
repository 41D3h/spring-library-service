package com.example.lib.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book() {}

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Set<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.getBooks().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
