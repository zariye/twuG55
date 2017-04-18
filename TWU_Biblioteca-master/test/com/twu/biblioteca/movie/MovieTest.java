package com.twu.biblioteca.movie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zgebru on 18.04.17.
 */
public class MovieTest {



  @Test
  public void equalsTest() {
    Movie theGodfather = new Movie("awesome name", 2015, "director", 4);
    Movie theGodfatherTwo = new Movie("awesome name", 2015, "director", 4);

    assertEquals(theGodfather, theGodfatherTwo);
  }
}
