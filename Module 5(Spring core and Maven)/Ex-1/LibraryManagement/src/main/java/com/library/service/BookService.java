package com.library.service;

public class BookService {

    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book - " + bookTitle);
    }

    public void displayBooks() {
        System.out.println("BookService: Displaying all books");
    }
}
