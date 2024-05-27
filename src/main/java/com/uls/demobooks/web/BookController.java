package com.uls.demobooks.web;

import com.uls.demobooks.domain.Book;
import com.uls.demobooks.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;
    @RequestMapping("/books")
    public Iterable<Book> getBooks() {
        return repository.findAll();
    }
}
