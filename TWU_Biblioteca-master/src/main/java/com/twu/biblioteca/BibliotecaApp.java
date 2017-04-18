package com.twu.biblioteca;


import com.twu.biblioteca.movie.MovieService;

public class BibliotecaApp {

    public static void main(String[] args) {
        new LibraryController(new LibraryView(), new MovieService()).start();
    }

}
