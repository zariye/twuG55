package com.twu.biblioteca.books;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class BookService {

    private List<Book> availableBooks;

    public BookService() {
        availableBooks = this.getAllBooks();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book("Head First Java", "1940", "Moritz"));
        allBooks.add(new Book("Test Driven Development", "1901", "Jonathan"));
        allBooks.add(new Book("History of the Awesome Kraut", "1200","Zara"));
        return allBooks;
    }

    public Book getBookByName(String name) {
        return getAllBooks().stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    public void checkoutBook(int index) {
        this.availableBooks.remove(index);
    }

    public boolean returnBook(Book book) {
        if (book != null) {
            availableBooks.add(book);
            return true;
        }
        return false;
    }



}
