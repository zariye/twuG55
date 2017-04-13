package com.twu.biblioteca.books;

import java.util.Arrays;
import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryController {

    LibraryViewInterface view;

    BookService bookService;

    public LibraryController(LibraryViewInterface libraryView) {
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
                view.listBooks(bookService.getAvailableBooks());
                break;
            }
        }
    }
}
