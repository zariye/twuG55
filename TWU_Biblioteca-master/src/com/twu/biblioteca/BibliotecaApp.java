package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private Menu menu;

    public BibliotecaApp() {
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
            default: {
                System.out.println("Select a valid option!");
                this.callMenu();

            }
        }
    }

    private void callMenu() {
        menu.drawMenu();
        int result = menu.readInput();
        this.executeCommand(result);
    }
}
