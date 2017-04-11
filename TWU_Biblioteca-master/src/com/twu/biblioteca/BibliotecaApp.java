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
        booksList.add(new Book("Head First Java", "1940", "Moritz"));
        booksList.add(new Book("Test Driven Development", "1901", "Jonathan"));
        booksList.add(new Book("History of the Awesome Kraut", "1200","Zara"));

        return booksList;
    }

    public void listBooks() {
        List<Book> books = this.getBooks();
        for(Book book : books) {
            System.out.println(book.getName() + " | " + book.getDate() + " | " + book.getAuthor());

        }
    }
}
