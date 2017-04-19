package com.twu.biblioteca;


import com.twu.biblioteca.movie.MovieService;
import com.twu.biblioteca.user.UserService;

public class BibliotecaApp {

    public static void main(String[] args) {
        new LibraryController(new LibraryView(), new MovieService(), new UserService()).start();
    }

}
