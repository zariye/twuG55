package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {
        new LibraryController(new LibraryView()).start();
    }

}
