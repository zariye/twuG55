package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moritz on 11/04/2017.
 */
public class Book {

    private String name;
    private String date;
    private String author;

    Book(String name, String date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    String getName() {
        return name;
    }

    String getDate() {
        return date;
    }

    String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object book) {

      Book newBook = (Book)book;

      return this.getName().equals(newBook.getName())
              && this.getDate().equals(newBook.getDate())
              && this.getAuthor().equals(newBook.getAuthor());
    }

    static Book getBookByName(String batman, List<Book> bookList) {
        for(Book book : bookList) {
            if (book.getName().equals(batman)) {
                return book;
            }
        }

        return null;
    }

    static List<Book> createBooksList() {
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Head First Java", "1940", "Moritz"));
        booksList.add(new Book("Test Driven Development", "1901", "Jonathan"));
        booksList.add(new Book("History of the Awesome Kraut", "1200","Zara"));
        return booksList;
    }
}
