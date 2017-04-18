package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryController {

    LibraryView view;

    BookService bookService;

    public LibraryController(LibraryView libraryView) {
        this.view = libraryView;
        this.bookService = new BookService();
    }

    public List<String> getMenuItems() {
        return Arrays.asList("[0] quit", "[1] list books", "[2] checkout", "[3] return book");
    }

    public void executeCommand(int command) {
        switch(command) {
            case 0: {
                System.exit(0);
                break;
            }
            case 1: {
                listBooks();
                break;
            }
            case 2: {
                view.showMessage("Please choose you book while writing the index:");
                listBooks();
                boolean result = checkoutBook(view.readInt());
                if(result) {
                    view.showMessage("Thank you! Enjoy the book");
                } else {
                    view.showMessage("That book is not available.");
                }
                break;
            }
            case 3 : {
                Book book = bookService.getBookByName(view.readLine());
                boolean result = this.returnBook(book);
                if (result) {
                    view.showMessage("Thank you for returning the book.");
                } else {
                    view.showMessage("That is not a valid book to return.");
                }
                break;
            }
            default: {
                view.showMessage("Select a valid option!");
            }
        }
    }

    private void listBooks() {
        view.listBooks(bookService.getAvailableBooks());
    }

    public List<Book> getAvailableBooks() {
        return this.bookService.getAvailableBooks();
    }

    public boolean checkoutBook(int bookIndex) {
        if(this.bookService.getAvailableBooks().size() > bookIndex) {
            this.bookService.checkoutBook(bookIndex);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (book != null) {
            this.bookService.returnBook(book);
            return true;
        }
        return false;
    }


    public void callMenu() {
        view.drawMenu(this.getMenuItems());
        int command = view.readInt();
        this.executeCommand(command);
        this.callMenu();
    }

    public void start() {
        view.showMessage("Hello user, welcome to the Bibliotheka App");
        callMenu();
    }
}
