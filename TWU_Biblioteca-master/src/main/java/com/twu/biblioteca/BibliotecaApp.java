package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.LibraryController;
import com.twu.biblioteca.books.LibraryView;

import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {
        new LibraryController(new LibraryView()).start();
    }

}
