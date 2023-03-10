package com.example.lib;

import com.example.lib.domain.Author;
import com.example.lib.domain.Book;
import com.example.lib.repos.AuthorRepository;
import com.example.lib.repos.BookRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public BookController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @GetMapping("")
    public String index(ModelMap model) {
        var books = bookRepo.findAllByOrderByName();

        model.addAttribute("books", books);
        return "book/index";
    }

    @PostMapping("")
    public String filter(@RequestParam String filter, ModelMap model) {
        Iterable<Book> books;

        if (!filter.isEmpty()) {
            books = bookRepo.findAllByNameOrderByName(filter);
        } else {
            books = bookRepo.findAllByOrderByName();
        }

        model.put("books", books);
        return  "book/index";
    }

    @GetMapping("/{id}")
    public String showBookPage(@PathVariable String id, ModelMap model) {
        try {
            // Same as in AuthorController
            var optionalBook = bookRepo.findById(Long.parseLong(id));
            var book = optionalBook.orElse(new Book("Книга не найдена"));

            model.put("book", book);
        } catch (Exception e) {
            return "redirect:book/index";
        }

        return "book/book";
    }

    @GetMapping("/add")
    public String showBookForm(ModelMap model) {
        model.addAttribute("book", new Book());

        var authors = authorRepo.findAll();
        model.put("authors", authors);

        return "book/add";
    }

    @PostMapping("/add")
    public String saveBook(@Valid @ModelAttribute Book book, ModelMap model) {
        String message;

        try {
            bookRepo.save(book);
            message = "Книга \"%s\" добавлена успешно!".formatted(book.getName());
        } catch (Exception e) {
            message = "Не удалось добавить книгу \"%s\"".formatted(book.getName());
        }

        model.put("message", message);

        return "redirect:/books/add";
    }
}
