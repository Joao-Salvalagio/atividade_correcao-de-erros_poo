package com.crud.demo.book.services;

import com.crud.demo.book.models.BookModel;
import com.crud.demo.book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public BookModel criarLivro(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public void  deletarLivro(Long id) {
        bookRepository.deleteById(id);
    }

    public BookModel update(BookModel bookModel) {
        BookModel book = bookRepository.findById(bookModel.getId()).get();
        book.setCategoria(bookModel.getCategoria());
        book.setNome(bookModel.getNome());
        return bookRepository.save(book);
    }
}
