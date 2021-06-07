package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // add book
    public Book addBook(Book book) {
        Book result = bookRepository.save(book);
        return result;
    }

    // delete book
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, int id) {
        book.setId(id);
        Book result = bookRepository.save(book);

        return result;
    }
}
