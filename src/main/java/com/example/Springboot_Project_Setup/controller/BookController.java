package com.example.Springboot_Project_Setup.controller;
import com.example.Springboot_Project_Setup.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        return "book-list";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam String title, @RequestParam String author, Model model) {
        books.add(new Book(title, author));
        model.addAttribute("books", books);
        return "book-table :: bookTable";
    }

    @GetMapping("/books/table")
    public String getBookTable(Model model) {
        model.addAttribute("books", books);
        return "book-table :: bookTable";
    }
}