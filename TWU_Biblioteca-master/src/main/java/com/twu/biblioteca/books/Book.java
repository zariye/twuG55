package com.twu.biblioteca.books;


/**
 * Created by moritz on 11/04/2017.
 */
public class Book {

    private String name;
    private String date;
    private String author;

    public Book(String name, String date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object book) {

      Book newBook = (Book)book;

      return this.getName().equals(newBook.getName())
              && this.getDate().equals(newBook.getDate())
              && this.getAuthor().equals(newBook.getAuthor());
    }

}
