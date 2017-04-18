package com.twu.biblioteca.movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by zgebru on 18.04.17.
 */
public class MovieServiceTest {

    MovieService movieService;
  
    @Before
    public void setup()  {
        movieService = new MovieService();
    }

    @Test
    public void testGetAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        assertThat(allMovies, hasItem(new Movie("batman", 2015, "robin", 7)));
    }

    @Test
    public void testGetAvailableMovies() {
        List<Movie> availableMovies = movieService.getAvailableMovies();
        assertTrue(availableMovies.get(0).isAvailable());
    }

    @Test
    public void testCheckoutMovie() {
        int index = 1;
        Movie movie = movieService.getAvailableMovies().get(index);
        assertTrue(movieService.tryToCheckoutMovie(index));

        assertThat(movieService.getAvailableMovies(), not(hasItem(movie)));
    }

    @Test
    public void testTryToCheckoutMovieWithWrongIndex() {
      int index = 80;

      assertFalse(movieService.tryToCheckoutMovie(index));
    }



}
