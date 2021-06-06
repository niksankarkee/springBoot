package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12, "Java Complete Reference", "Niksan"));
        list.add(new Book(13, "Node JS Complete Guidance", "MAX"));
        list.add(new Book(15, "php Complete Guidance", "gROVER"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // add book
    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    // delete book
    public void deleteBook(int id) {
        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

    public List<Book> updateBook(Book book, int id) {
        list = list.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());

        return list;
    }
}
