package com.twu.biblioteca.books;

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

    LibraryView bookView;

    @Before
    public void setup() {
        bookView = new LibraryView();
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testShowMessage() {
        String message = "Hello user, welcome to the Bibliotheca App";
        bookView.showMessage(message);
        assertEquals(message + "\n", systemOutRule.getLog());
    }

    @Test
    public void testListBooks() {
        List<Book> books = new BookService().getAllBooks();
        bookView.listBooks(books);

        assertEquals("[0] Head First Java | 1940 | Moritz\n" +
                "[1] Test Driven Development | 1901 | Jonathan\n" +
                "[2] History of the Awesome Kraut | 1200 | Zara\n", systemOutRule.getLog());
    }

    @Test
    public void testDrawMenu() {
        bookView.drawMenu(new LibraryController(new LibraryViewMock()).getMenuItems());
        assertEquals("[0] quit\n[1] list books\n[2] checkout\n[3] return book\n", systemOutRule.getLog());
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testReadInt() {
        systemInMock.provideLines("1337");
        assertEquals(1337, bookView.readInt());
    }

    @Test
    public void testReadLine() {
        String bookName = "History of the Awesome Kraut";
        systemInMock.provideLines(bookName);
        assertEquals(bookName, bookView.readLine());
    }
}
