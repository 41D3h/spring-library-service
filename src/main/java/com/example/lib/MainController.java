package com.example.lib;

import com.example.lib.repos.AuthorRepository;
import com.example.lib.repos.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public MainController(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/")
    public String showMainPage(ModelMap model) {
        var books = bookRepo.findFirst10ByOrderByIdDesc();

        model.put("books", books);

        return "main";
    }
}
