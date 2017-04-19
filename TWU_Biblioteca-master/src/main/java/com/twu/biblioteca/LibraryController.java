package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookService;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.MovieService;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryController {

    LibraryView view;

    BookService bookService;

    MovieService movieService;

    UserService userService;

    public LibraryController(LibraryView libraryView, MovieService movieService, UserService userService) {
        this.view = libraryView;
        this.bookService = new BookService();
        this.movieService = movieService;
        this.userService = userService;
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
                verifyLogin();
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
                verifyLogin();
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
                verifyLogin();
                int movieIndex = view.readInt();
                movieService.tryToCheckoutMovie(movieIndex);
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

    public User verifyLogin() {
        view.showMessage("Input your library number please");
        String ID = view.readLine();
        view.showMessage("Input your password please");
        String password = view.readLine();
        userService.login(ID, password);
        return userService.getCurrentUser();
    }
}
