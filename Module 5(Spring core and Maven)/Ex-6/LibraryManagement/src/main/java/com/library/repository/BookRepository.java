package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: Saving book -> " + bookTitle);
    }

    public String findById(int id) {
        return "BookRepository: Found book with ID " + id;
    }
}
