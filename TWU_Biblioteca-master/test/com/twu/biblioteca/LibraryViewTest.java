package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookService;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.MovieService;
import com.twu.biblioteca.user.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryViewTest {

    LibraryView libraryView;

    @Before
    public void setup() {
        libraryView = new LibraryView();
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testShowMessage() {
        String message = "Hello user, welcome to the Bibliotheca App";
        libraryView.showMessage(message);
        assertEquals(message + "\n", systemOutRule.getLog());
    }

    @Test
    public void testListBooks() {
        List<Book> books = new BookService().getAllBooks();
        libraryView.listBooks(books);

        assertEquals("[0] Head First Java | 1940 | Moritz\n" +
                "[1] Test Driven Development | 1901 | Jonathan\n" +
                "[2] History of the Awesome Kraut | 1200 | Zara\n", systemOutRule.getLog());
    }

    @Test
    public void testDrawMenu() {
        libraryView.drawMenu(new LibraryController(new LibraryView(), new MovieService(), new UserService()).getMenuItems());
        assertEquals("[0] quit\n[1] list books\n[2] checkout\n[3] return book\n[4] list movies\n[5] checkout movie\n", systemOutRule.getLog());
    }

    @Test
    public void testListMovies() {
        List<Movie> allMovies = new MovieService().getAllMovies();
        libraryView.listMovies(allMovies);

        assertEquals("[0] batman | 2015 | robin | 7\n[1] jack | 2000 | bill | 1\n[2] theMovie | 2011 | ron | 9\n", systemOutRule.getLog());
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testReadInt() {
        systemInMock.provideLines("1337");
        assertEquals(1337, libraryView.readInt());
    }

    @Test
    public void testReadLine() {
        String bookName = "History of the Awesome Kraut";
        systemInMock.provideLines(bookName);
        assertEquals(bookName, libraryView.readLine());
    }
}
