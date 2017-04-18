package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookService;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.MovieService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryController {

    LibraryView view;

    BookService bookService;

    MovieService movieService;

    public LibraryController(LibraryView libraryView) {
        this.view = libraryView;
        this.bookService = new BookService();
        this.movieService = new MovieService();
    }

    public List<String> getMenuItems() {
        return Arrays.asList("[0] quit", "[1] list books", "[2] checkout", "[3] return book", "[4] list movies", "[5] checkout movie");
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
            case 4: {
                view.listMovies(movieService.getAvailableMovies());
                break;
            }
            case 5: {
                int movieIndex = view.readInt();
                this.checkoutMovie(movieIndex);
                view.showMessage("Thank you! Enjoy the movie.");
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

    public List<Movie> getAvailableMovies() {
        return this.movieService.getAvailableMovies();
    }

    public void checkoutMovie(int index) {
        this.movieService.checkoutMovie(index);
    }
}
