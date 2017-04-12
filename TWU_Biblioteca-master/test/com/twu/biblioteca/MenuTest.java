package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by zgebru on 12/04/2017.
 */
public class MenuTest {

  private Menu menu;

  private OutputStream out;

  @Before
  public void setUp() {
    menu = new Menu();

    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  @Test
  public void testDrawMenu() {
    menu.drawMenu();

    assertEquals("list books\n", out.toString());
  }

}
