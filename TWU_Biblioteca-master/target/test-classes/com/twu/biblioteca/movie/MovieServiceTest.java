package com.twu.biblioteca.movie;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        assertThat(allMovies, CoreMatchers.hasItem(new Movie("batman", 2015, "robin", 7)));
    }

    @Test
    public void testGetAvailableMovies() {
        List<Movie> availableMovies = movieService.getAvailableMovies();
        assertTrue(availableMovies.get(0).isAvailable());
    }

}
