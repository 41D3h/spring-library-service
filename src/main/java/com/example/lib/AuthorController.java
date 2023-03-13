package com.example.lib;

import com.example.lib.domain.Author;
import com.example.lib.repos.AuthorRepository;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("")
    public String main(Map<String, Object> model) {
        var authors = authorRepo.findAllByOrderBySurname();

        model.put("authors", authors);
        return "author/index";
    }

    @PostMapping("")
    public String filter(@RequestParam String filter, ModelMap model) {
        Iterable<Author> authors;

        if (!filter.isEmpty()) {
            authors = authorRepo.findAllByNameOrSurnameOrPatronymicOrderBySurname(filter, filter, filter);
        } else {
            authors = authorRepo.findAllByOrderBySurname();
        }

        model.put("authors", authors);
        return  "author/index";
    }

    @GetMapping("/{id}")
    public String showAuthorPage(@PathVariable String id, ModelMap model) {
        try {
            // getById for some reason doesn't provide correct result
            // will go with Optional. It has some similarities with maybe monad
            var optionalAuthor = authorRepo.findById(Long.parseLong(id));
            var author = optionalAuthor.orElse(new Author("Этот","автор","не существует"));

            model.put("author", author);
        } catch (Exception e) {
            return "redirect:author/index";
        }

        return "author/author";
    }

    @GetMapping("/add")
    public String showAuthorForm(ModelMap model) {
        model.addAttribute("author", new Author());

        return "author/add";
    }

    @PostMapping("/add")
    public String saveAuthor(@Valid @ModelAttribute Author author, ModelMap model) {
        String message;
        String authorsFullName = author.getName() + author.getSurname() + author.getPatronymic();

        try {
            authorRepo.save(author);
            message = "Author " + authorsFullName + " added successfully!";
        } catch (Exception e) {
            message = "Can't add author " + authorsFullName;
        }

        model.put("message", message);
        return "author/add";
    }
}
