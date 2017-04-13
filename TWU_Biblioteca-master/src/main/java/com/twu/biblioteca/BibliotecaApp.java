package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;

import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {

    private Menu menu;

    private List<Book> allBooks;
    private List<Book> stockBooks;

    BibliotecaApp() {
        allBooks = Book.createBooksList();
        stockBooks = Book.createBooksList();
        menu = new Menu();
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        greetUser();
        this.callMenu();
    }

    public void greetUser() {
        System.out.println("Hello user, welcome to the Bibliotheka App");
    }

    public List<Book> getBooks() {
        return stockBooks;
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
            case 3 : {
                if (returnBook(Book.getBookByName(readBookName(), allBooks))) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                break;
            }
            default: {
                System.out.println("Select a valid option!");

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
        this.callMenu();
    }

    void deleteBook(int bookIndex) {
        if(getBooks().size() > bookIndex) {
            getBooks().remove(bookIndex);
        } else {
            System.out.println("That book is not available.");
        }
    }

    boolean returnBook(Book book) {
        if (book != null) {
            stockBooks.add(book);
            return true;
        }
        return false;
    }

    private String readBookName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    List<Book> getAllBooks() {
        return allBooks;
    }
}
