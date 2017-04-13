package com.twu.biblioteca.books;

import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public interface LibraryViewInterface {
    void showMessage(String message);

    void listBooks(List<Book> books);

    void drawMenu(List<String> menuItems);

    int readInt();

    String readLine();
}
