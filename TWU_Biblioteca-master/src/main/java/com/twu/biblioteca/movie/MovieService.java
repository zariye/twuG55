package com.twu.biblioteca.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 18/04/2017.
 */
public class MovieService {

    List<Movie> allMovies;

    public MovieService() {
        allMovies = new ArrayList<>();
        allMovies.add(new Movie("batman", 2015, "robin", 7));
        allMovies.add(new Movie("jack", 2000, "bill", 1));
        allMovies.add(new Movie("theMovie", 2011, "ron", 9));
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>();
        for(Movie movie: allMovies) {
            if (movie.isAvailable()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }


    public boolean tryToCheckoutMovie(int index) {
        if (index >= 0 && index < getAvailableMovies().size()) {
            this.getAvailableMovies().get(index).setAvailable(false);
            return true;
        }
        return false;
    }
}
