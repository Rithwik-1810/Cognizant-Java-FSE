package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String libraryName;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection applied.");
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("BookService: Setter injection applied. Library = " + libraryName);
    }

    public void addBook(String bookTitle) {
        bookRepository.save(bookTitle);
        System.out.println("BookService [" + libraryName + "]: Book added successfully.");
    }

    public void getBook(int id) {
        String result = bookRepository.findById(id);
        System.out.println("BookService: " + result);
    }
}
