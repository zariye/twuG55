package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

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

        assertEquals("Head First Java | 1940 | Moritz\nTest Driven Development | 1901 | Jonathan\nHistory of the Awesome Kraut | 1200 | Zara\n", out.toString());
    }

    @Test
    public void testListBooksCommand() {
        int command = 1;
        app.executeCommand(command);
        assertEquals("Head First Java | 1940 | Moritz\nTest Driven Development | 1901 | Jonathan\nHistory of the Awesome Kraut | 1200 | Zara\n", out.toString());

    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();


    @Test
    public void testQuitCommand() {
        int command = 0;
        exit.expectSystemExit();
        app.executeCommand(command);

    }




}
