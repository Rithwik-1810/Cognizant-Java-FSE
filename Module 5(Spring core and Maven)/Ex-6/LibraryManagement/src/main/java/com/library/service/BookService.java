package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        bookRepository.save(bookTitle);
        System.out.println("BookService: Book added using annotation-based configuration.");
    }

    public void getBook(int id) {
        String result = bookRepository.findById(id);
        System.out.println("BookService: " + result);
    }
}
