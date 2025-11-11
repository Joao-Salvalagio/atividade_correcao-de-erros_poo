package com.crud.demo.book.controllers;


import com.crud.demo.book.models.BookModel;
import com.crud.demo.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookModel> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public BookModel save(@RequestBody BookModel bookModel){
        return bookService.criarLivro(bookModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.deletarLivro(id);
    }

    @PutMapping("/{id}")
    public BookModel update(@PathVariable Long id, @RequestBody BookModel bookModel){
        return bookService.update(bookModel);
    }
}