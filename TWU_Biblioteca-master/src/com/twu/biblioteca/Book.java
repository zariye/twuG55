package com.twu.biblioteca;

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

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object book) {

      Book newBook = (Book)book;

      return this.getName().equals(newBook.getName())
              && this.getDate().equals(newBook.getDate())
              && this.getAuthor().equals(newBook.getAuthor());

    }

}
