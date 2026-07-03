package com.library.repository;

public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("Saving book: " + bookTitle);
    }

    public String findById(int id) {
        return "Book with ID: " + id;
    }
}
