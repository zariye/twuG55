package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

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
        BibliotecaApp.main(new String[] {});
        assertEquals("Hello user welcome to the Bibliotheka App\n", out.toString());
    }

    @Test
    public void testGetBooks() {
        List<Book> books = app.getBooks();

        assertNotNull(books);
        assertFalse(books.isEmpty());


    }

    @Test
    public void testListBooks() {
        app.listBooks();
        assertEquals("Head First Java\nTest Driven Development\nHistory of the Awesome Kraut\n", out.toString());

    }
}
