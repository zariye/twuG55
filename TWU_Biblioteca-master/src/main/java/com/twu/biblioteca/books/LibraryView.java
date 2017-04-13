package com.twu.biblioteca.books;

import java.util.List;
import java.util.Scanner;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryView implements LibraryViewInterface {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }


    @Override
    public void listBooks(List<Book> books) {
        for(Book book : books) {
            System.out.println("[" + books.indexOf(book) + "] " + book.getName() + " | " + book.getDate() + " | " + book.getAuthor());
        }
    }

    @Override
    public void drawMenu(List<String> menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
    }

    @Override
    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
