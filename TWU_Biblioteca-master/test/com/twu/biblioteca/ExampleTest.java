package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private OutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testGreeting() {
        BibliotecaApp.main(new String[] {});
        assertEquals("Hello user welcome to the Bibliotheka App\n", out.toString());
    }
}
