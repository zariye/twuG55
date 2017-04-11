package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        greetUser();
    }

    private void greetUser() {
        System.out.println("Hello user welcome to the Bibliotheka App");
    }

    protected List<Book> getBooks() {
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Head First Java"));
        booksList.add(new Book("Test Driven Development"));
        booksList.add(new Book("History of the Awesome Kraut"));

        return booksList;
    }

    public void listBooks() {
        List<Book> book1 = this.getBooks();
        for(Book book : book1) {
            System.out.println(book.getName());
        }
    }
}
