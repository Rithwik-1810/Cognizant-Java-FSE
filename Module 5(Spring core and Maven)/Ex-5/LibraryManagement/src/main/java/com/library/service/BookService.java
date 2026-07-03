package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        bookRepository.save(bookTitle);
        System.out.println("BookService: Book processed through IoC container.");
    }

    public void getBook(int id) {
        String result = bookRepository.findById(id);
        System.out.println("BookService: " + result);
    }
}
