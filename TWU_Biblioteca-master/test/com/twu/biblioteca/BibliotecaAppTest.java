package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaAppTest {

    private OutputStream out;
    private BibliotecaApp app;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        app = new BibliotecaApp();
    }

    @Test
    public void testGreeting() {
        app.greetUser();
        assertTrue(out.toString().contains("Hello user welcome to the Bibliotheka App\n"));
    }

    @Test
    public void testGetBooks() {
        List<Book> books = app.getBooks();

        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(new Book("Head First Java", "1940", "Moritz"), books.get(0));

    }

    @Test
    public void testListBooks() {
        app.listBooks();

        assertEquals("[0] Head First Java | 1940 | Moritz\n" +
            "[1] Test Driven Development | 1901 | Jonathan\n" +
            "[2] History of the Awesome Kraut | 1200 | Zara\n", out.toString());
    }

    @Test
    public void testListBooksCommand() {
        int command = 1;
        app.executeCommand(command);

        assertEquals("[0] Head First Java | 1940 | Moritz\n" +
            "[1] Test Driven Development | 1901 | Jonathan\n" +
            "[2] History of the Awesome Kraut | 1200 | Zara\n", out.toString());

    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();


    @Test
    public void testQuitCommand() {
        int command = 0;
        exit.expectSystemExit();
        app.executeCommand(command);
    }


    @Test
    public void testCheckoutBook() {
        List<Book> books = app.getBooks();
        Book rmBook = books.get(1);
        app.deleteBook(1);
        assertFalse(app.getBooks().contains(rmBook));
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testCheckoutBookCommand() {
        systemInMock.provideLines("2", "0");
        Book rmBook = app.getBooks().get(2);

        int command = 2;
        app.executeCommand(command);

        assertTrue(out.toString().contains("Please choose you book while writing the index:\n"));
        assertFalse(app.getBooks().contains(rmBook));
        assertTrue(out.toString().contains("Thank you! Enjoy the book\n"));
    }

    @Test
    public void testUnsuccessfullCheckoutBookCommand() {
        systemInMock.provideLines("100", "0");
        Book rmBook = app.getBooks().get(1);

        int command = 2;
        app.executeCommand(command);

        assertTrue(out.toString().contains("That book is not available."));
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("batman","1789", "bruce");
        app.returnBook(book);
        List<Book> books = app.getBooks();

        assertTrue(books.contains(book));
    }

    @Test
    public void testReturnBookCommand() {
        systemInMock.provideLines("batman");

        int command = 3;
        app.executeCommand(command);

        assertEquals(out.toString(), "Thank you for returning the book.\n");
    }


}
