package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private Menu menu;

    private List<Book> booksList;

    public BibliotecaApp() {
        booksList = createBooksList();
        menu = new Menu();
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        greetUser();
        this.callMenu();
    }

    public void greetUser() {
        System.out.println("Hello user welcome to the Bibliotheka App");
    }

    protected List<Book> getBooks() {

        return booksList;
    }

    private List<Book> createBooksList() {
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(new Book("Head First Java", "1940", "Moritz"));
        booksList.add(new Book("Test Driven Development", "1901", "Jonathan"));
        booksList.add(new Book("History of the Awesome Kraut", "1200","Zara"));
        return booksList;
    }

    public void listBooks() {
        List<Book> books = this.getBooks();
        for(Book book : books) {
            System.out.println("[" + books.indexOf(book) + "] " + book.getName() + " | " + book.getDate() + " | " + book.getAuthor());

        }
    }

    public void executeCommand(int command) {
        switch(command) {
            case 0 : {
                System.exit(0);
                break;
            }
            case 1: {
                this.listBooks();
                break;
            }
            case 2 : {
                System.out.println("Please choose you book while writing the index:");
                listBooks();
                deleteBook(readBookIndex());
                System.out.println("Thank you! Enjoy the book");
                break;
            }
            default: {
                System.out.println("Select a valid option!");
                this.callMenu();

            }
        }
    }

    private int readBookIndex() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private void callMenu() {
        menu.drawMenu();
        int result = menu.readInput();
        this.executeCommand(result);
    }

    public void deleteBook(int bookIndex) {
        if(getBooks().size() > bookIndex) {
            getBooks().remove(bookIndex);
        } else {
            System.out.println("That book is not available.");
        }
    }
}
