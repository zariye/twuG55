package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.List;
import java.util.Scanner;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryView {

    public void showMessage(String message) {
        System.out.println(message);
    }


    public void listBooks(List<Book> books) {
        for(Book book : books) {
            System.out.println("[" + books.indexOf(book) + "] " + book.getName() + " | " + book.getDate() + " | " + book.getAuthor());
        }
    }

    public void drawMenu(List<String> menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
    }

    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void listMovies(List<Movie> allMovies) {
        for(Movie movie : allMovies) {
            System.out.println("[" + allMovies.indexOf(movie) + "] " + movie.getName() + " | " + movie.getYear() + " | " + movie.getDirector() + " | " + movie.getRating());
        }
    }
}
